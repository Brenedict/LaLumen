import { useState } from 'react'
import { Routes, Route, Link } from 'react-router-dom'

import Home from './components/Home'
import Records from './components/Records'
import Navbar from './components/Navbar'

function App() {
  return (
    <>
      <Navbar></Navbar>
      <Routes>
        <Route path='/home' element = {<Home/>} />
        <Route path='/records' element = {<Records/>} />
      </Routes>
    </>
  )
}

export default App
