import { useState, useContext } from "react";

import { WorkContext, useWorkContext } from "../contexts/WorkContextProvider";

function Records() { 
    const {accountWorkRecords, setAccountWorkRecords} = useWorkContext();

    return (
        <div>
            <ul>
                {
                    // Add ternary condition for checking if login was a success
                    accountWorkRecords.map((work) => (
                        <li>{JSON.stringify(work)}</li>
                    ))
                }
            </ul>
        </div>
    );
}

export default Records;