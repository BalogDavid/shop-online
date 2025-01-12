import axios from "./axios";

const login = (username, password) => {
    return axios.post("/auth/login", { username, password }); // Log the user in
};

const signup = (username, email, password) => {
    return axios.post("/auth/signup", { username, email, password }); // Register a new user
};

const logout = () => {
    localStorage.removeItem("token"); // Clear the token when logging out
};

const getToken = () => {
    return localStorage.getItem("token"); // Retrieve the auth token from local storage
};

export default {
    login,
    signup,
    logout,
    getToken,
};