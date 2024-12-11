import React from "react";
import "./App.css";
import {Route, Routes} from "react-router-dom";
import {AUTH_PATH_SIGN_UP, REVIEW_PATH, STATS_DAILY, STATS_MENU, MY_PAGE, MY_PAGE_UPDATE} from "./constants";
import Review from "./views/Review/Review";
import MenusStats from "./views/Stats/MenusStats";
import DailyStats from "./views/Stats/DailyStats";
import SignUp from "./views/Authentication/SignUp/SignUp";
import Header from "./layouts/Header/index";
import Footer from "./layouts/Footer";
import Mypage from "./views/Mypage/Mypage";
import MypageUpdate from "./views/Mypage/MypageUpdate";

function App() {
    return (
        <div className="App">
            <Header/>
            <Routes>
                <Route path={AUTH_PATH_SIGN_UP} element={<SignUp/>}></Route>
                <Route path={REVIEW_PATH} element={<Review/>}></Route>
                <Route path={STATS_MENU} element={<MenusStats/>}></Route>
                <Route path={STATS_DAILY} element={<DailyStats/>}></Route>
                <Route path={MY_PAGE} element={<Mypage/>}></Route>
                <Route path={MY_PAGE_UPDATE} element={<MypageUpdate/>}></Route>
            </Routes>
            <Footer/>
        </div>
    );
}

export default App;
