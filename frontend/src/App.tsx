import { useState } from 'react'
import { Routes, Route, Link } from 'react-router-dom'
import './App.css'

import Home from './components/home'
import Records from './components/Records'

function App() {
  return (
    <>
      <Link to = "/home">Home</Link>
      <br />
      <Link to = "/records">Records</Link>
      <Routes>
        <Route path='/home' element = {<Home/>} />
        <Route path='/records' element = {<Records/>} />
      </Routes>
    </>
  )
}

export default App
