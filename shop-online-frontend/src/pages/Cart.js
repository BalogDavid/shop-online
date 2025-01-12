import React, { useEffect, useState } from "react";
import CartService from "../services/CartService";

export default function Cart() {
    const [cartItems, setCartItems] = useState([]);
    const [errorMessage, setErrorMessage] = useState("");

    useEffect(() => {
        // Fetch the user ID from localStorage
        const userId = localStorage.getItem("userId"); // Assuming your app sets this for logged-in users

        if (userId) {
            // Fetch cart items when the page loads for the specific user
            CartService.getCartItems(userId)
                .then((response) => {
                    console.log("Cart items fetched:", response.data); // Debug response
                    setCartItems(response.data); // Update cart items state
                })
                .catch((error) => {
                    console.error("Error fetching cart items:", error);
                    setErrorMessage("Unable to load your cart. Please try again later.");
                });
        } else {
            console.error("User ID is not available. Ensure the user is logged in.");
            setErrorMessage("User is not logged in. Please log in to see your cart.");
        }
    }, []);

    const handleRemoveFromCart = (itemId) => {
        CartService.removeCartItem(itemId)
            .then(() => {
                // Update the UI after removing an item
                setCartItems(cartItems.filter((item) => item.id !== itemId));
                alert("Item removed successfully from the cart!");
            })
            .catch((error) => {
                console.error("Error removing item:", error);
                setErrorMessage("Unable to remove the item at this time.");
            });
    };

    if (errorMessage) {
        // Render error message if there's an error
        return (
            <div className="container mt-4">
                <p className="text-danger">{errorMessage}</p>
            </div>
        );
    }

    return (
        <div className="container mt-4">
            <h2>Coșul Tău</h2>
            {cartItems.length === 0 ? (
                <p>Coșul tău este gol.</p>
            ) : (
                <ul className="list-group">
                    {cartItems.map((item) => (
                        <li
                            className="list-group-item d-flex justify-content-between align-items-center"
                            key={item.id}
                        >
                            {item.name}
                            <span>${item.price}</span>
                            <button
                                className="btn btn-danger btn-sm"
                                onClick={() => handleRemoveFromCart(item.id)}
                            >
                                Remove
                            </button>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}