export interface WorkCategoryInterface {
    categoryId: number,
    categoryName: string
}

export interface WorkInterface {
    workId: number,
    workDate: string,
    timeStart: string,
    logTitle: string,
    logDescription: string,
    productivityRating: number,
    lastModifiedAt: string,
    deletedAt: string | null,
    workCategories: WorkCategoryInterface[],
    deleted: boolean
}

export const fetchRecords = async (accountId: number): Promise<WorkInterface[]> => {
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