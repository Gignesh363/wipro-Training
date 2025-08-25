import React, { Component } from "react";
import MenuItem from "./MenuItem";

class Restaurant extends Component {
  render() {
    const restaurantName = "Spice Hub";
    const location = "Block B, First Floor";
    const openHours = "10:00 AM - 10:00 PM";

    const menuItems = [
      { name: "Paneer Butter Masala", price: 150, category: "Main Course", available: true },
      { name: "Chicken Biryani", price: 200, category: "Main Course", available: true },
      { name: "Masala Dosa", price: 80, category: "Breakfast", available: true },
      { name: "Gulab Jamun", price: 40, category: "Dessert", available: false },
      { name: "Veg Thali", price: 120, category: "Combo", available: true },
    ];

    return (
      <div style={{ margin: "20px" }}>
        <h2> 8.Restaurant Name: {restaurantName}</h2>
        <p><strong>Location:</strong> {location}</p>
        <p><strong>Open Hours:</strong> {openHours}</p>

        <h3>Restaurant Menu:</h3>
        <ul>
          {menuItems.map((item, index) => (
            <MenuItem
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
  }
}

export default Restaurant;
