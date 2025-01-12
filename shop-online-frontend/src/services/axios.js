import axios from "axios";

// Base URL for your backend API
const BASE_URL = "http://localhost:8080/api"; // Backend API base URL

// Create an axios instance with default settings
const axiosInstance = axios.create({
    baseURL: BASE_URL,
    headers: {
        "Content-Type": "application/json", // Set default content type
    },
    withCredentials: true, // Allow cross-origin requests with cookies or credentials
});

// Add a response interceptor for error handling (optional)
axiosInstance.interceptors.response.use(
    (response) => response, // If the response is successful, return it
    (error) => {
        // Handle errors globally, e.g., redirect to login on 401
        if (error.response && error.response.status === 401) {
            console.error("Unauthorized - You may need to log in.");
        }
        return Promise.reject(error);
    }
);

export default axiosInstance;