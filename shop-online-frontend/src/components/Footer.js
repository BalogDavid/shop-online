import React from "react";

export default function Footer() {
    return (
        <footer className="bg-light text-center text-lg-start mt-5">
            <div className="text-center p-3" style={{ backgroundColor: "rgba(0, 0, 0, 0.2)" }}>
                © {new Date().getFullYear()} Shop Online
            </div>
        </footer>
    );
}