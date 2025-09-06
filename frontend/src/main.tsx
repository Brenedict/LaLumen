import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter } from 'react-router-dom'

import App from './App.tsx'

// Context Providing Components
import WorkContextProvider from './contexts/WorkContextProvider'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <WorkContextProvider>
      <BrowserRouter>
        <App />
      </BrowserRouter>
    </WorkContextProvider>
  </StrictMode>
)
