import React, { useState, useEffect } from "react";

import Filters from "./Filters";
import ProductListing from "./ProductListing";

export default function ProductsApp() {
  const [products, setProducts] = useState([]);
  const [filters, setFilters] = useState({
    searchQuery: '',
    category: 'all',
    minPrice: -1,
    maxPrice: -1,
  });
  
  useEffect(() => {
    fetch("https://dummyjson.com/products?limit=100")
      .then((res) => res.json())
      .then((data) => {
        setProducts(data.products);
      })
      .catch((error) => console.log(error));
  }, []);

  const getCategories = () => {
    const categories = [];
    products.forEach(product => {
      if (!categories.includes(product.category)) {
        categories.push(product.category);
      }
    })
    return categories;
  }

  return (
    <div>
      <Filters filters={filters} setFilters={setFilters} categories={getCategories()}/>
      <ProductListing products={products} filters={filters} />
    </div>
  );
}
