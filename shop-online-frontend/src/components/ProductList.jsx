import React, { useEffect, useState } from "react";
import ProductService from "../services/ProductService";

const ProductList = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        ProductService.getAllProducts()
            .then((response) => {
                console.log("Fetched Products:", response.data); // Debug - Log fetched product data
                setProducts(response.data);
            })
            .catch((error) => console.error("Error loading products:", error));
    }, []);

    return (
        <div className="product-list">
            {products.map((product) => (
                <div key={product.id} className="product-item">
                    <img
                        src={
                            product.imagine && product.imagine.trim() !== "" // Validate imagine field
                                ? `http://localhost:8080/${product.imagine}` // Full URL for dynamic image
                                : "https://via.placeholder.com/150" // Fallback to a placeholder if missing
                        }
                        alt={product.nume || "Product Image"} // Fallback alt text
                        className="product-image"
                        onError={(e) => {
                            console.error(
                                `Error loading image for product ID ${product.id}: Falling back to placeholder.`
                            );
                            e.target.src = "https://via.placeholder.com/150"; // Placeholder fallback on error
                        }}
                    />
                    <h3>{product.nume || "Unnamed Product"}</h3> {/* Fallback for missing name */}
                    <p>
                        Price: $
                        {product.pret !== undefined
                            ? product.pret.toFixed(2) // Display price if available
                            : "N/A"} {/* Fallback for missing price */}
                    </p>
                </div>
            ))}
        </div>
    );
};

export default ProductList;