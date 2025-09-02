import { Link } from "react-router-dom";

import "../styles/Navbar.css"

function Navbar() {
    return(
        <div className="nav-container">
            <div className="nav-links">
                <Link to="/home">Home</Link>
                <Link to="/">Summmary</Link>
                <Link to="/records">Records</Link>
                <Link to="/">Settings</Link>
            </div>
        </div>
    );
}


export default Navbar;