import { useEffect, useState, useRef} from 'react'
import { Routes, Route, Link } from 'react-router-dom'

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

  return (
    <div className={styles.appContainer}>
      <Navbar/>
      {
        isLogin === false ? (<Login />) : (
          <Routes>
            <Route path='/home' element = {<Home/>} />
            <Route path='/records' element = {<Records/>} />
            <Route path='/journal' element = {<Journal/>} />
            <Route path='/settings' element = {<Settings/>} />
          </Routes>    
        )
      }
      </div>
  )
}

export default App
