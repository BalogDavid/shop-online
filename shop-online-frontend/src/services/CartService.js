import axios from "./axios";

const getCartItems = (userId) => {
    const token = localStorage.getItem("token");
    if (!token) {
        console.error("No token found. Please log in again.");
        return Promise.reject("No token found.");
    }
    if (!userId) {
        console.error("No userId provided.");
        return Promise.reject("No userId provided.");
    }

    return axios.get(`/cos/${userId}`, {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    });
};

const addCartItem = (productId, userId) => {
    const token = localStorage.getItem("token");
    if (!token) {
        console.error("No token found. Please log in again.");
        return Promise.reject("No token found.");
    }
    if (!userId || !productId) {
        console.error("Missing userId or productId.");
        return Promise.reject("Missing userId or productId.");
    }

    return axios.post(
        "/cos/adauga",
        null,
        {
            params: { produsId: productId, utilizatorId: userId },
            headers: {
                Authorization: `Bearer ${token}`,
            },
        }
    );
};

const removeCartItem = (itemId) => {
    const token = localStorage.getItem("token");
    if (!token) {
        console.error("No token found. Please log in again.");
        return Promise.reject("No token found.");
    }
    if (!itemId) {
        console.error("No itemId provided.");
        return Promise.reject("No itemId provided.");
    }

    return axios.delete(`/cos/remove/${itemId}`, {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    });
};

export default {
    getCartItems,
    addCartItem,
    removeCartItem,
};