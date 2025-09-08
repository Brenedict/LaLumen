import { useState } from "react";

import { handleLogin, type LoginRequestInterface, type AccountResponseInterface } from "../services/accountService";
import { useWorkContext } from "../contexts/WorkContextProvider";
import { fetchWorkRecords, type WorkInterface } from "../services/recordService";
function Login() {
    const {
        accountInfo, setAccountInfo, 
        accountWorkRecords, setAccountWorkRecords,
        isLogin, setIsLogin
    } = useWorkContext();
    
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loginMessage, setLoginMessage] = useState("") 
    
    const login = async () => {
        try {
            const credentials: LoginRequestInterface = {username, password}
            
            const accountResponse: AccountResponseInterface = await handleLogin(credentials);
                        
            localStorage.setItem("accountId", accountResponse.accountId.toString());

            setAccountInfo(accountResponse);
            updateWorkContext(accountResponse.accountId);
            setIsLogin(true);

            // Temporary
            setLoginMessage("");
            
        }
        catch (error: any) {
            console.error(error.message);
            setLoginMessage(error.message);
        }
    } 

    const updateWorkContext = async (accountId: number) => {
        const workRecordsResponse: WorkInterface[] = await fetchWorkRecords(accountId);
        setAccountWorkRecords(workRecordsResponse);
    }

    return(
        <>
            <div>
                <input type="text" placeholder="enter username" onChange={(e) => setUsername(e.target.value)}/>
                <input type="password" placeholder="enter password" onChange={(e) => setPassword(e.target.value)}/>
                <button onClick={login}>Login</button>
            </div>
        </>
    )
}

export default Login;