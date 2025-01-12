import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <div className="container">
                <Link to="/" className="navbar-brand">
                    Shop Online
                </Link>
                <button
                    className="navbar-toggler"
                    type="button"
                    data-toggle="collapse"
                    data-target="#navbarNav"
                    aria-controls="navbarNav"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                >
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item">
                            <Link to="/" className="nav-link">
                                Acasă
                            </Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/login" className="nav-link">
                                Autentificare
                            </Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/signup" className="nav-link">
                                Înregistrare
                            </Link>
                        </li>
                        <li className="nav-item">
                            <Link to="/cart" className="nav-link">
                                Coș Cumpărături
                            </Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
}