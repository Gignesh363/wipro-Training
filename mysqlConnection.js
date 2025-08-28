const mysql = require("mysql");

const connection = mysql.createConnection({
  host: "localhost",
  user: "root",        // change if your MySQL user is different
  password: "pass123", // change to your MySQL password
  database: "stock_market"
});

connection.connect((err) => {
  if (err) {
    console.error("Error connecting to MySQL:", err);
    return;
  }
  console.log("Connected to MySQL database");
});

module.exports = connection;
