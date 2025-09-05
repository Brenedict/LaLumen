import { useState } from "react";

import { handleLogin, type LoginRequestInterface, type AccountResponseInterface } from "../services/accountService";
import { useWorkContext } from "../contexts/WorkContextProvider";
import { fetchWorkRecords, type ErrorResponseInterface, type WorkInterface } from "../services/recordService";
function Login() {
    const {accountWorkRecords, setAccountWorkRecords} = useWorkContext();
    
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [accountInfo, setAccountInfo] = useState<AccountResponseInterface>();
    const [isLogin, setIsLogin] = useState(false);
    
    const login = async () => {
        console.log("Called")
        const credentials: LoginRequestInterface = {username, password}
        
        const accountResponse: AccountResponseInterface = await handleLogin(credentials);

        // Add checking if login is successfull
        // This if statement doesn't work because response in this case is an error response: timestamp, endpoint url

        if(accountResponse) {
            setAccountInfo(accountResponse);
            setIsLogin(true);
            updateWorkContext(accountResponse.accountId);
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