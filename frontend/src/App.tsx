import { useEffect, useState, useRef} from 'react'
import { Routes, Route, Link } from 'react-router-dom'

// Components
import Navbar from './components/Navbar'
import Home from './components/Home'
import Records from './components/Records'
import Journal from './components/Journal'
import Settings from './components/Settings'

// API Services Related
import { type LoginRequestInterface, type AccountResponseInterface, handleLogin } from './services/accountService'
import { type WorkInterface, type WorkCategoryInterface, fetchRecords } from './services/recordService'

function App() {
  return (
    <>
    <Navbar/>
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
