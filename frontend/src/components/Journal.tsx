import { useWorkContext } from "../contexts/WorkContextProvider";


type EntryProps = {
    title: string;
    description: string;
}

function Entry({title, description}: EntryProps) {
    return (
        <>
            <h1>{title}</h1>
            <h5>{description}</h5>
            <br />
        </>
    )
}

function Journal() {
    const {accountWorkRecords, setAccountWorkRecords, accountWorkCategories, setAccountWorkCategories} = useWorkContext();
    return (
        <div>
            <h1>
                Journal
            </h1>
            
            {accountWorkRecords.length === 0 ? (
                <li>Nothing to see here...</li> 
            ) : (
                accountWorkRecords.map((work, idx) => (
                    <Entry title = {work.logTitle} description = {work.logDescription}/>
                ))
            )}
        </div>
    );
}

export default Journal;