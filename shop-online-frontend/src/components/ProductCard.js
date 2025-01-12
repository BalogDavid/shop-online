import React from "react";

export default function ProductCard({ product, onAddToCart }) {
    return (
        <div className="card" style={{ width: "18rem" }}>
            <img
                src={product.imageUrl || "https://via.placeholder.com/150"}
                className="card-img-top"
                alt={product.name}
            />
            <div className="card-body">
                <h5 className="card-title">{product.name}</h5>
                <p className="card-text">RON {product.price}</p>
                <button
                    className="btn btn-primary"
                    onClick={() => onAddToCart(product.id)}
                >
                    Adaugă în coș
                </button>
            </div>
        </div>
    );
}