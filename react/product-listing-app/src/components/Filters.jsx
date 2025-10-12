import React, { useState } from "react";

export default function Filters({ filters, setFilters, categories }) {
  const updateFilters = (key, value) => {
    setFilters({
      ...filters,
      [key]: value,
    });
  };

  return (
    <div>
      <input
        placeholder="Search Query"
        type="text"
        value={filters.searchQuery}
        onChange={(e) => {
          updateFilters("searchQuery", e.target.value);
        }}
      />

      <select
        placeholder="Category"
        value={filters.category}
        onChange={(e) => {
          updateFilters("category", e.target.value);
        }}
      >
        <option key="all" value="all">
          Show All
        </option>
        {categories.map((category) => (
          <option key={category} value={category}>
            {category}
          </option>
        ))}
      </select>

      <input
        placeholder="Min Price"
        type="number"
        value={filters.minPrice}
        onChange={(e) => {
          updateFilters("minPrice", +e.target.value);
        }}
      />

      <input
        placeholder="Max Price"
        type="number"
        value={filters.maxPrice}
        onChange={(e) => {
          updateFilters("maxPrice", +e.target.value);
        }}
      />
    </div>
  );
}
