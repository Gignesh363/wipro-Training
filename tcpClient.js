const net = require("net");
const readline = require("readline");

// Create interface for user input
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// connect to server at port 8080
const client = net.createConnection({ port: 8080 }, () => {
  console.log("✅ Connected to server");
  console.log("👉 Type a command (LIST | ADD <id> <name> <quantity> <price> | EXIT):");
});

// receive data from server
client.on("data", (data) => {
  console.log("📩 Server says:", data.toString());
});

// handle connection close
client.on("end", () => {
  console.log("❌ Disconnected from server");
  rl.close();
});

// Read user input and send to server
rl.on("line", (input) => {
  client.write(input);

  // if user typed EXIT, close client
  if (input.trim().toUpperCase() === "EXIT") {
    client.end();
  }
});
