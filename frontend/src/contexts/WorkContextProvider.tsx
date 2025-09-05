import { createContext, useContext, useEffect, useState, type ReactNode } from "react";

// From API Services
import { type WorkInterface } from "../services/recordService";
import { fetchWorkRecords } from "../services/recordService";
import type { AccountResponseInterface } from "../services/accountService";

interface WorkContextInterface {
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
    const [accountWorkRecords, setAccountWorkRecords] = useState<WorkInterface[]>([]);
    
    const persistingId = localStorage.getItem("accountId");

    if(persistingId) {   
        useEffect(() => {
            const fetchWorks = async (accountId: number) => {
                const workRecordsResponse: WorkInterface[] = await fetchWorkRecords(accountId);
                
                setAccountWorkRecords(workRecordsResponse);
            }
            
            fetchWorks(Number.parseInt(persistingId));
        }, [])
    }
        
    return (
        <>
            <h1>Account Id: {persistingId}</h1>
            <WorkContext.Provider value={{accountWorkRecords, setAccountWorkRecords}}>
                {children}
            </WorkContext.Provider>
        </>
    )
}

export default WorkContextProvider;