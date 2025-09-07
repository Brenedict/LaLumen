import { Link } from "react-router-dom";

import styles from "../styles/Navbar.module.css"

function Navbar() {
    return(
        <div className={styles.navContainer}>
            <div className={styles.navLinks}>
                <Link to="/home">home</Link>
                <Link to="/records">records</Link>
                <Link to="/journal">journal</Link>
                <Link to="/settings">settings</Link>
            </div>
        </div>
    );
}


export default Navbar;