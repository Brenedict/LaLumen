export interface LoginRequestInterface {
    username: string,
    password: string
}

export interface AccountResponseInterface {
    accountId: number,
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
        
    if(!rawResponse.ok) {
        const errorData = await rawResponse.json();
        throw new Error(errorData.message);
    }

    const result = await rawResponse.json()

    return result;
}

export const handleAutoLogin = async (accountId: number): Promise<AccountResponseInterface> => {
    const URL = `http://127.0.0.1:8080/account/auth/${accountId}`;
    const rawResponse = await fetch(URL, 
        {
            method: "POST", 
            headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });

    if (!rawResponse.ok) {
        const errorData = await rawResponse.json();
        throw new Error(errorData.message);   
    }
        
    const result = await rawResponse.json()

    return result;
}