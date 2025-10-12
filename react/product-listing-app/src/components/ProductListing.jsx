import React from "react";

import Product from "./Product";

export default function ProductListing({ products, filters }) {
  const getFilteredProducts = () => {
    return products.filter((product) => {
      const { searchQuery, category, minPrice, maxPrice } = filters;

      if (
        (searchQuery === null ||
          searchQuery === "" ||
          product.title.toLowerCase().includes(searchQuery.toLowerCase())) &&
        (category === "all" || product.category === category) &&
        (minPrice === -1 || product.price >= minPrice) &&
        (maxPrice === -1 || product.price <= maxPrice)
      ) {
        return true;
      }

      return false;
    });
  };

  const filteredProducts = getFilteredProducts();

  if (filteredProducts.length == 0) {
    return <div>No products to display</div>;
  }

  return filteredProducts.map((product) => (
    <Product key={product.id} product={product} />
  ));
}
