import { Link } from "react-router-dom";

import "../styles/Navbar.css"

function Navbar() {
    return(
        <div className="nav-container">
            <div className="nav-links">
                <Link to="/home">home</Link>
                <Link to="/records">records</Link>
                <Link to="/journal">journal</Link>
                <Link to="/settings">settings</Link>
            </div>
        </div>
    );
}


export default Navbar;