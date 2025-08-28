const net = require("net");
const readline = require("readline");

// Connect to server
const client = new net.Socket();
client.connect(5000, "127.0.0.1", () => {
  console.log("Connected to server!");
});

// Handle server responses
client.on("data", (data) => {
  console.log("Server Response:\n" + data.toString());
});

// Handle disconnection
client.on("close", () => {
  console.log("Connection closed.");
  process.exit(0);
});

// CLI input
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (input) => {
  client.write(input);
});
