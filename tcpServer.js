const net = require("net");
const mysql = require("mysql2");

// ✅ Connect to MySQL
const db = mysql.createConnection({
  host: "localhost",
  user: "root",        // change if needed
  password: "pass123",    // change if needed
  database: "stock_market"
});

// ✅ Ensure table exists
db.query(`
  CREATE TABLE IF NOT EXISTS jewellery (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    quantity INT,
    price DECIMAL(10,2)
  )
`);

// ✅ Create TCP server
const server = net.createServer((socket) => {
  console.log("📢 Client connected");

  socket.write("Welcome to Jewellery Store TCP Server!\n");
  socket.write("Commands: LIST | ADD <id> <name> <quantity> <price> | EXIT\n");

  socket.on("data", (data) => {
    const input = data.toString().trim();
    const parts = input.split(" ");
    const command = parts[0].toUpperCase();

    if (command === "LIST") {
      db.query("SELECT * FROM jewellery", (err, results) => {
        if (err) {
          socket.write("❌ DB Error: " + err.message + "\n");
          return;
        }
        socket.write(JSON.stringify(results) + "\n");
      });

    } else if (command === "ADD") {
      if (parts.length < 5) {
        socket.write("❌ Usage: ADD <id> <name> <quantity> <price>\n");
        return;
      }

      const id = parseInt(parts[1]);
      const name = parts[2];
      const quantity = parseInt(parts[3]);
      const price = parseFloat(parts[4]);

      const sql = "INSERT INTO jewellery (id, name, quantity, price) VALUES (?, ?, ?, ?)";
      db.query(sql, [id, name, quantity, price], (err) => {
        if (err) {
          socket.write("❌ DB Error: " + err.message + "\n");
          return;
        }
        socket.write(`✅ Added ${name} successfully!\n`);
      });

    } else if (command === "EXIT") {
      socket.write("👋 Goodbye!\n");
      socket.end();

    } else {
      socket.write("Unknown command. Try LIST, ADD, EXIT.\n");
    }
  });

  socket.on("end", () => {
    console.log("❌ Client disconnected");
  });
});

// ✅ Start server
server.listen(8080, () => {
  console.log("🚀 Jewellery TCP Server running on port 8080");
});
