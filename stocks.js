const db = require("./mysqlConnection");

// CREATE
function addStock(symbol, companyName, price, volume, callback) {
  const query = "INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)";
  db.query(query, [symbol, companyName, price, volume], (err, result) => {
    if (err) return callback(err);
    console.log("Inserted stock with ID:", result.insertId);
    callback(null, result.insertId);
  });
}

// READ
function listStocks(callback) {
  db.query("SELECT * FROM stocks", (err, results) => {
    if (err) return callback(err);
    console.log("All Stocks:", results);
    callback(null, results);
  });
}

// UPDATE
function updateStockPriceAndVolume(id, price, volume, callback) {
  const query = "UPDATE stocks SET price = ?, volume = ? WHERE id = ?";
  db.query(query, [price, volume, id], (err, result) => {
    if (err) return callback(err);
    console.log(`Updated stock ID: ${id}`);
    callback(null, result);
  });
}

// DELETE
function deleteStock(id, callback) {
  db.query("DELETE FROM stocks WHERE id = ?", [id], (err, result) => {
    if (err) return callback(err);
    console.log(`Deleted stock ID: ${id}`);
    callback(null, result);
  });
}

// Sequential Execution
addStock("AAPL", "Apple Inc.", 175.50, 1000, (err, insertedId) => {
  if (err) throw err;

  listStocks((err, stocks) => {
    if (err) throw err;

    updateStockPriceAndVolume(insertedId, 189.00, 1200, (err) => {
      if (err) throw err;

      listStocks((err, updatedStocks) => {
        if (err) throw err;

        deleteStock(insertedId, (err) => {
          if (err) throw err;

          listStocks((err, finalStocks) => {
            if (err) throw err;
            db.end(); // close connection
          });
        });
      });
    });
  });
});
