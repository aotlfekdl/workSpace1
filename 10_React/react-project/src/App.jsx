import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import JavaScript from './components/JavaScript'
import Style from './components/Style'
import Products from './components/Products'


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      {/* <JavaScript /> */}
      {/* <Style /> */}
      <Products/>
    </>
  )
}

export default App
