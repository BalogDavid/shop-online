import React, { useState } from "react";
import axios from "../services/axios";

export default function Login() {
    const [credentials, setCredentials] = useState({ email: "", password: "" });
    const [error, setError] = useState(null);

    const handleSubmit = (event) => {
        event.preventDefault();
        setError(null); // Reset error before submitting

        // Send login request to the backend
        axios.post("/auth/login", credentials)
            .then((response) => {
                // Save token and userId in localStorage
                const { token, userId } = response.data;
                console.log("Login response data:", response.data); // Debugging the backend response

                localStorage.setItem("token", token); // Save token
                localStorage.setItem("userId", userId); // Save userId

                alert("Login successful!");
                window.location.href = "/"; // Redirect to home after login
            })
            .catch((err) => {
                console.error("Login error:", err);
                if (err.response && err.response.status === 401) {
                    setError("Invalid email or password");
                } else {
                    setError("An unexpected error occurred. Please try again.");
                }
            });
    };

    return (
        <div className="container mt-4">
            <h2>Autentificare</h2>
            {error && <p className="text-danger">{error}</p>}
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Email</label>
                    <input
                        type="email"
                        className="form-control"
                        value={credentials.email}
                        onChange={(e) =>
                            setCredentials({ ...credentials, email: e.target.value })
                        }
                    />
                </div>
                <div className="form-group">
                    <label>Parolă</label>
                    <input
                        type="password"
                        className="form-control"
                        value={credentials.password}
                        onChange={(e) =>
                            setCredentials({ ...credentials, password: e.target.value })
                        }
                    />
                </div>
                <button type="submit" className="btn btn-primary">
                    Login
                </button>
            </form>
        </div>
    );
}