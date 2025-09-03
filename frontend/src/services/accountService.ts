export interface LoginRequestInterface {
    username: string,
    password: string
}

export interface AccountResponseInterface {
    id: number,
    username: string
}

export const handleLogin = async (credentials: LoginRequestInterface): Promise<AccountResponseInterface> => {
    const URL = `http://127.0.0.1:8080/account/auth`;
    const rawResponse = await fetch(URL, 
        {
            method: "POST", 
            headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(credentials)
        });
        
    // Insert error checking ^^
    const result = await rawResponse.json()

    return result;
}