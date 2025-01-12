import React, { useEffect, useState } from "react";
import ProductCard from "../components/ProductCard";
import ProductService from "../services/ProductService";
import CartService from "../services/CartService";

export default function Home() {
    const [products, setProducts] = useState([]); // Initialize as an empty array
    const [errorMessage, setErrorMessage] = useState("");

    useEffect(() => {
        ProductService.getAllProducts()
            .then((response) => {
                console.log("API Response:", response.data); // Inspect the response data
                if (Array.isArray(response.data)) {
                    // Map API fields to match the fields expected by ProductCard
                    const mappedProducts = response.data.map((product) => ({
                        id: product.id,
                        name: product.nume, // Map `nume` to `name`
                        price: product.pret, // Map `pret` to `price`
                        imageUrl: product.imagine, // Map `imagine` to `imageUrl`
                    }));
                    setProducts(mappedProducts);
                } else {
                    setErrorMessage("Unexpected response format from API.");
                    console.error("Unexpected data format:", response.data);
                }
            })
            .catch((error) => {
                console.error("Error fetching products:", error);
                setErrorMessage("Failed to load products.");
            });
    }, []);

    const handleAddToCart = (productId) => {
        const userId = localStorage.getItem("userId"); // Assuming userId is stored after login

        if (!userId) {
            console.error("User ID is unavailable. Ensure the user is logged in.");
            alert("You must log in to add items to the cart!");
            return;
        }

        CartService.addCartItem(productId, userId)
            .then(() => {
                console.log(`Product ${productId} successfully added to cart.`);
                alert("Product added to cart successfully!"); // Basic feedback
            })
            .catch((error) => {
                console.error("Failed to add product to the cart:", error);
                alert("Failed to add product to the cart. Please try again.");
            });
    };

    if (errorMessage) {
        // Display an error message if something goes wrong
        return <div className="container mt-4"><p>{errorMessage}</p></div>;
    }

    return (
        <div className="container mt-4">
            <h1>Listă Produse Disponibile</h1>
            <div className="row">
                {products.length > 0 ? (
                    products.map((product) => (
                        <div className="col-md-4 mb-3" key={product.id}>
                            <ProductCard product={product} onAddToCart={handleAddToCart} />
                        </div>
                    ))
                ) : (
                    <p>Nici un produs disponibil.</p>
                )}
            </div>
        </div>
    );
}