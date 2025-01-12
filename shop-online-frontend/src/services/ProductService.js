import axios from "./axios";

const getAllProducts = () => {
    return axios.get("/produse"); // Fetch all products
};

const getProductById = (id) => {
    return axios.get(`/produse/${id}`); // Fetch product by ID
};

export default {
    getAllProducts,
    getProductById,
};