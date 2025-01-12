import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import Cart from "./pages/Cart";
import ProtectedRoute from "./routes/ProtectedRoute";
import ProductList from "./components/ProductList";

export default function App() {
    return (
        <Router>
            <Navbar />
            <div className="container mt-5">
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/signup" element={<Signup />} />
                    {/* Protect the cart route */}
                    <Route
                        path="/cart"
                        element={
                            <ProtectedRoute>
                                <Cart />
                            </ProtectedRoute>
                        }
                    />
                    {/* New route for the product list */}
                    <Route path="/products" element={<ProductList />} />
                </Routes>
            </div>
            <Footer />
        </Router>
    );
}