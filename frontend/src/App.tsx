import { useEffect, useState, useRef} from 'react'
import { Routes, Route, Link } from 'react-router-dom'

import Home from './components/Home'
import Records from './components/Records'
import Navbar from './components/Navbar'
import { type LoginRequestInterface, type AccountResponseInterface, handleLogin } from './services/accountService'
import { type WorkInterface, type WorkCategoryInterface, fetchRecords } from './services/recordService'

function App() {
  const [username, setUsername] = useState("Benedict");
  const [password, setPassword] = useState("Benedict1234");
  const [loginStatus, setLoginStatus] = useState(false);
  const [workRecords, setWorkRecords] = useState<WorkInterface[]>([]);
  
  // Change to context
  const accountId = useRef(0);

  const handleCredentialsCheck = async () => {
      const loginRequest: LoginRequestInterface = {username, password};

      const response: AccountResponseInterface = await handleLogin(loginRequest);
      console.log(response);
      

      if(!response.username) {
        throw console.error("Nde man gana uy");
      }

      setLoginStatus(true);
      accountId.current = response.id;
      fetchWorkRecords();
  }

  const fetchWorkRecords = async () => {
    const response: WorkInterface[] = await fetchRecords(accountId.current);
    
    setWorkRecords(response);
    console.log(response);
  }

  return (
    <>

      <input type="text" placeholder='username' onChange={(e) => setUsername(e.target.value)}/>
      <input type="text" placeholder='password' onChange={(e) => setPassword(e.target.value)}/>
      <br />
      <button onClick={handleCredentialsCheck}>Login</button>

      {
        loginStatus == false ? (
        <h2>Not login</h2>
      ) : (
        <ul>
          {workRecords.map((value) => (
            <li>{JSON.stringify(value)}</li>
          ))}
        </ul>
      )
    }
    <Navbar/>
      <Routes>
        <Route path='/home' element = {<Home/>} />
        <Route path='/records' element = {<Records/>} />
      </Routes>
    </>
  )
}

export default App
