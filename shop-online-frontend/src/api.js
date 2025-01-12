import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/api', // URL-ul backend-ului tău Spring Boot
});

export default api;
