import React from "react";

const CanteenItem = ({ name, price, category, available }) => {
  return (
    <li>
      {name} - Price: ₹{price} - Category: {category} - {available === "Yes" ? "Available" : "No Available"}  
      {/*  Ternari operator */}
    </li>
  );
};

export default CanteenItem;
