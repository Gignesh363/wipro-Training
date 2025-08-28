// vatCalculator.js

// Exported function to calculate VAT and total price
function calculateVAT(price, vatPercent = 3) {
  const vat = (vatPercent / 100) * price;
  const totalPrice = price + vat;

  return {
    vat,
    totalPrice
  };
}

module.exports = { calculateVAT };
