const express = require("express");
const bodyParser = require("body-parser");
const path = require("path");

const app = express();
const PORT = 3000;

// Middleware
app.use(bodyParser.urlencoded({ extended: true }));

// Serve index.html
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "index.html"));
});

// Handle form submission
app.post("/submit", (req, res) => {
  const { trackingId, senderName, receiverName, pickupAddress, deliveryAddress, weight } = req.body;

  // Calculate delivery cost
  const deliveryCost = 50 + (parseInt(weight) * 20);

  // Respond with confirmation
  res.send(`
    <h2>Courier Booking Confirmation</h2>
    <p><strong>Courier Tracking ID:</strong> ${trackingId}</p>
    <p><strong>Sender:</strong> ${senderName}</p>
    <p><strong>Receiver:</strong> ${receiverName}</p>
    <p><strong>Pickup:</strong> ${pickupAddress}</p>
    <p><strong>Delivery:</strong> ${deliveryAddress}</p>
    <p><strong>Weight:</strong> ${weight} kg</p>
    <p><strong>Delivery Cost:</strong> ₹${deliveryCost}</p>
  `);
});

// Start server
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
