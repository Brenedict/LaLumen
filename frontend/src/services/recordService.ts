export interface WorkCategoryInterface {
    categoryId: number,
    categoryName: string
    categoryColor: string;
}

export interface WorkInterface {
    workId: number,
    workDate: string,
    timeStart: string,
    duration: string,
    logTitle: string,
    logDescription: string,
    productivityRating: number,
    lastModifiedAt: string,
    deletedAt: string | null,
    isDeleted: boolean 
    workCategories: WorkCategoryInterface[],
}

export interface ErrorResponseInterface {
    timestamp: string,
    statusCode: number,
    path: string,
    message: string
}

export const fetchWorkRecords = async (accountId: number): Promise<WorkInterface[]> => {
    const URL = `http://127.0.0.1:8080/work/${accountId}/account-id`;
    const rawResponse =  await fetch(URL, 
        {
            method: "GET", 
            headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    
    // Insert error checking ^^
    const result = await rawResponse.json()

    return result;
}

export const fetchWorkCategories = async (accountId: number): Promise<WorkCategoryInterface[]> => {
    const URL = `http://127.0.0.1:8080/category/${accountId}/account-id`;
    const rawResponse =  await fetch(URL, 
        {
            method: "GET", 
            headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    
    // Insert error checking ^^
    const result = await rawResponse.json()

    return result;
}