// app.js
const { calculateVAT } = require("./vatCalculator");

// Example Jewellery item
const jewelleryItem = {
  id: 1,
  name: "Gold Necklace",
  price: 50000
};

// Use the module to calculate VAT and total price
const result = calculateVAT(jewelleryItem.price);

// Display Output
console.log(`Jewellery ID: ${jewelleryItem.id}`);
console.log(`Name: ${jewelleryItem.name}`);
console.log(`Price: ${jewelleryItem.price}`);
console.log(`VAT (3%): ${result.vat}`);
console.log(`Total Price: ${result.totalPrice}`);
