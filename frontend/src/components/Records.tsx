import { useState, useContext } from "react";

import { WorkContext, useWorkContext } from "../contexts/WorkContextProvider";

function Records() { 
    const {accountWorkRecords, setAccountWorkRecords} = useWorkContext();

    return (
        <div>
            <ul>
                {accountWorkRecords.length === 0 ? (
                    <li>Nothing to see here...</li>
                ) : (
                    accountWorkRecords.map((work, idx) => (
                        <li key={idx}>{JSON.stringify(work)}</li>
                    ))
                )}
            </ul>
        </div>
    );
}

export default Records;