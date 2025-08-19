import React from "react";
import CanteenItem from "./CanteenItem";

const CanteenMenu = () => {
  const menuItems = [
    { name: "Idli", price: 30, category: "Breakfast", available: "Yes" },
    { name: "Dosa", price: 5, category: "Breakfast", available: "Yes" },
    { name: "Vada", price: 2, category: "Snack", available: "No" },
    { name: "Poori", price: 40, category: "Breakfast", available: "Yes" },
    { name: "Meals", price: 120, category: "Lunch", available: "Yes" }
  ];

  return (
    <div style={{ margin: "20px" }}>
      <h2>6.Canteen Name: Campus Food Court</h2>
      <p>Location: Block A, Ground Floor</p>
      <p>Open Hours: 8:00 AM - 8:00 PM</p>

      <h3>Canteen Menu:</h3>
      <ul>
        {menuItems.map((item, index) => (
          <CanteenItem
            key={index}
            name={item.name}
            price={item.price}
            category={item.category}
            available={item.available}
          />
        ))}
      </ul>
    </div>
  );
};

export default CanteenMenu;
