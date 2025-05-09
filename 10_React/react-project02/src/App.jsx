// import { useState } from 'react';
import './App.css';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import HomePage from './pages/HomePage';
import PostListPage from './pages/PostListPage';
import IconButton from './02_components/IconButton';
import GlobalStyle from './GlobalStyle';
import { ThemeProvider } from 'styled-components';
// import { lightTheme, darkTheme } from './themes';
import ThemeBox from './02_components/ThemeBox';
// import { toast, ToastContainer } from 'react-toastify';
// import { performToast } from './utils/performToast';
import SimpleForm from './02_components/SimpleForm';
import LoaderDemo from './02_components/LoaderDemo';

// setTimeout(() => {
//   performToast({msg: '등록완료', type: 'success'})
// }, 1000);


// setTimeout(() => {
//   performToast({msg: '등록실패', type: 'error'})
// }, 1000);

// setTimeout(() => {
//   performToast({msg: '에러발생', type: 'warning'})
// }, 1000);
// toast.success('요청에 성공하였습니다.');
// toast.error('요청에 실패하였습니다.');
// toast.warning('요청이 올바르지 않습니다.');
// performToast({msg: '등록완료', type: 'success'})

function App() {
  // const [isDark, setIsDark] = useState(false);
  // const toggleTheme = () => setIsDark(!isDark);

  // const apiUrl = import.meta.env.VITE_API_URL;
  // console.log(apiUrl);

  return (
    // <Router>
    //   <Routes>
    //     <Route path='/' element={<HomePage />} />
    //     <Route path="/posts" element={<PostListPage />} />
    //   </Routes>
    // </Router>

    // {**/ <IconButton/>/*}
    // <ThemeProvider theme={isDark ? darkTheme : lightTheme}>
    //   <GlobalStyle />
    //   <ThemeBox onToggleTheme={toggleTheme} />
    // </ThemeProvider>
    // <ToastContainer/>
    // <SimpleForm/>
    <LoaderDemo/>
  );
}

export default App;
