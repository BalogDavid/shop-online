import React, { useState } from "react";
import axios from "../services/axios";

export default function Signup() {
    const [userData, setUserData] = useState({
        nume: "", // Updated field to match the backend
        email: "",
        password: "",
    });

    const [success, setSuccess] = useState(false);

    const handleSubmit = (event) => {
        event.preventDefault();
        // Send signup request
        axios.post("/auth/signup", userData)
            .then((response) => {
                setSuccess(true);
                alert("Account created successfully! You can now log in.");
                setUserData({ nume: "", email: "", password: "" }); // Reset form fields
            })
            .catch((error) => {
                console.error("Error creating account:", error);
                if (error.response && error.response.status === 400) {
                    alert("Validation error: " + error.response.data);
                } else {
                    alert("There was an error creating your account. Try again.");
                }
            });
    };

    return (
        <div className="container mt-4">
            <h2>Înregistrare</h2>
            {success && <p className="text-success">Signup successful!</p>}
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Nume</label> {/* Updated label */}
                    <input
                        type="text"
                        className="form-control"
                        value={userData.nume} // Updated to nume
                        onChange={(e) =>
                            setUserData({ ...userData, nume: e.target.value })
                        }
                    />
                </div>
                <div className="form-group">
                    <label>Email</label>
                    <input
                        type="email"
                        className="form-control"
                        value={userData.email}
                        onChange={(e) =>
                            setUserData({ ...userData, email: e.target.value })
                        }
                    />
                </div>
                <div className="form-group">
                    <label>Parolă</label>
                    <input
                        type="password"
                        className="form-control"
                        value={userData.password}
                        onChange={(e) =>
                            setUserData({ ...userData, password: e.target.value })
                        }
                    />
                </div>
                <button type="submit" className="btn btn-primary">
                    Signup
                </button>
            </form>
        </div>
    );
}