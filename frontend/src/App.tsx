import { useEffect, useState, useRef} from 'react'
import { Routes, Route, Link } from 'react-router-dom'

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
    <>
      <Navbar/>
      {
        isLogin === false ? (<Login />) : (
          <h2>Welcome {accountInfo?.username}</h2>
        )
      }
      <Routes>
        <Route path='/home' element = {<Home/>} />
        <Route path='/records' element = {<Records/>} />
        <Route path='/journal' element = {<Journal/>} />
        <Route path='/settings' element = {<Settings/>} />
      </Routes>
    </>
  )
}

export default App
