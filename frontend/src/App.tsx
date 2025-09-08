import { useEffect, useState, useRef} from 'react'
import { Routes, Route, Link, Navigate } from 'react-router-dom'

import styles from "./styles/App.module.css"

// Components
import Navbar from './components/Navbar'
import Home from './components/Home'
import Records from './components/Records'
import Journal from './components/Journal'
import Settings from './components/Settings'
import Login from './components/Login'

// Context Providing Components
import WorkContextProvider, { useWorkContext } from './contexts/WorkContextProvider'

function App() {
  const {
    accountInfo, setAccountInfo, 
    accountWorkRecords, setAccountWorkRecords,
    isLogin, setIsLogin
  } = useWorkContext();

  const tempLogOff = () => {
    localStorage.removeItem("accountId");
    setIsLogin(false);
  }

  return (
    <div className={styles.appContainer}>
      {isLogin && <a onClick={tempLogOff}style={{
        color: 'white',
        textDecoration: 'underline',
        cursor: 'pointer'
        }}>Log Out</a>
        }
      <Navbar/>
      {
        isLogin === false ? (<Login />) : (
          <Routes>
            <Route path='/home' element = {<Home/>} />
            <Route path='/records' element = {<Records/>} />
            <Route path='/journal' element = {<Journal/>} />
            <Route path='/settings' element = {<Settings/>} />
            <Route path='*' element = {<Navigate to="home" replace />}/>
          </Routes>    
        )
      }
      </div>
  )
}

export default App
