import React, { createContext, useContext, useEffect, useState, type ReactNode } from "react";

// From API Services
import { type WorkInterface, type WorkCategoryInterface } from "../services/recordService";
import { fetchWorkRecords, fetchWorkCategories } from "../services/recordService";
import { handleAutoLogin, handleLogin, type AccountResponseInterface } from "../services/accountService";

interface WorkContextInterface {
    isLogin: boolean;
    setIsLogin: React.Dispatch<React.SetStateAction<boolean>>
    accountInfo: AccountResponseInterface | undefined;
    setAccountInfo: React.Dispatch<React.SetStateAction<AccountResponseInterface | undefined>>;
    accountWorkCategories: WorkCategoryInterface[];
    setAccountWorkCategories: React.Dispatch<React.SetStateAction<WorkCategoryInterface[]>>
    accountWorkRecords: WorkInterface[];
    setAccountWorkRecords: React.Dispatch<React.SetStateAction<WorkInterface[]>>
}

export const WorkContext = createContext<WorkContextInterface | undefined >(undefined);

// Clears WorkContext from undefined behavior
export const useWorkContext = () => {
    const context = useContext(WorkContext);

    if(!context) {
        throw new Error("useWorkContext must be within WorkContextProvider");
    }

    return context;
}

function WorkContextProvider({ children }: { children: ReactNode}) {
    const [isLogin, setIsLogin] = useState<boolean>(false);
    const [accountInfo, setAccountInfo] = useState<AccountResponseInterface | undefined>();
    const [accountWorkRecords, setAccountWorkRecords] = useState<WorkInterface[]>([]);
    const [accountWorkCategories, setAccountWorkCategories] = useState<WorkCategoryInterface[]>([]);
    
    
    useEffect(() => {
        const persistingId = localStorage.getItem("accountId");
        if(!persistingId) {
            return;
        }
        
        const fetchWorks = async (accountId: number) => {
            try {
                const accountInfo: AccountResponseInterface = await handleAutoLogin(accountId);
                
                const workRecordsResponse: WorkInterface[] = await fetchWorkRecords(accountId);
                const workCategoriesResponse: WorkCategoryInterface[] = await fetchWorkCategories(accountId);
                
                setAccountWorkRecords(workRecordsResponse);
                setAccountWorkCategories(workCategoriesResponse);
                setIsLogin(true);
            }
            catch (error: any) {
                console.error(error.message)
            }
        }
        
        fetchWorks(Number.parseInt(persistingId));
    }, [])
        
    return (
        <>
            <WorkContext.Provider value={{isLogin, setIsLogin, accountInfo, setAccountInfo, accountWorkRecords, setAccountWorkRecords, accountWorkCategories, setAccountWorkCategories}}>
                {children}
            </WorkContext.Provider>
        </>
    )
}

export default WorkContextProvider;