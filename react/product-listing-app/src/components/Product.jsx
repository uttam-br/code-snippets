import React from "react";

export default function Product({ product }) {
  return (
    <div
      style={{
        border: "1px solid red",
        margin: 2,
      }}
    >
      {product.title}
    </div>
  );
}
