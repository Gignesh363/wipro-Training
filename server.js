const net = require("net");

// In-memory jewellery items
let jewelleryItems = [
  { id: 1, name: "Gold Ring", quantity: 5, price: 15000 },
  { id: 2, name: "Silver Necklace", quantity: 3, price: 5000 }
];

// Create TCP server
const server = net.createServer((socket) => {
  console.log("Client connected!");

  socket.write("Welcome to Jewellery Store TCP Server!\n");
  socket.write("Commands: LIST | ADD <id> <name> <quantity> <price> | EXIT\n");

  socket.on("data", (data) => {
    const input = data.toString().trim();
    const [command, ...args] = input.split(" ");

    if (command === "LIST") {
      let response = jewelleryItems
        .map(
          (item) =>
            `ID: ${item.id}, Name: ${item.name}, Quantity: ${item.quantity}, Price: ${item.price}`
        )
        .join("\n");
      socket.write(response + "\n");
    } 
    else if (command === "ADD") {
      if (args.length < 4) {
        socket.write("Invalid ADD format! Use: ADD <id> <name> <quantity> <price>\n");
      } else {
        const [id, name, quantity, price] = args;
        jewelleryItems.push({
          id: parseInt(id),
          name,
          quantity: parseInt(quantity),
          price: parseInt(price),
        });
        console.log(`Item added: ${name}`);
        socket.write("Jewellery item added successfully!\n");
      }
    } 
    else if (command === "EXIT") {
      socket.write("Goodbye!\n");
      socket.end();
    } 
    else {
      socket.write("Unknown command. Try LIST, ADD, EXIT.\n");
    }
  });

  socket.on("end", () => {
    console.log("Client disconnected");
  });

  socket.on("error", (err) => {
    console.error("Error:", err.message);
  });
});

// Start server
const PORT = 5000;
server.listen(PORT, () => {
  console.log(`TCP Server running on port ${PORT}`);
});
