import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter as Router } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

// Find the root element in your HTML
const rootElement = document.getElementById('root');

// Create a root using ReactDOM.createRoot (React 18+)
const root = ReactDOM.createRoot(rootElement);

// Render the React App
root.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>
);
