const fs = require("fs");
const path = require("path");

// File paths
const fruitsFile = path.join(__dirname, "fruits.txt");
const fruitsCopyFile = path.join(__dirname, "fruits_copy.txt");

// Fruit data
const fruits = [
  { id: 1, name: "Apple", color: "Red", price: 120 },
  { id: 2, name: "Banana", color: "Yellow", price: 40 },
  { id: 3, name: "Mango", color: "Orange", price: 150 }
];

// 1. Create a Writable Stream -> Write fruit data to fruits.txt
const writeStream = fs.createWriteStream(fruitsFile);

fruits.forEach(fruit => {
  writeStream.write(JSON.stringify(fruit) + "\n");
});

writeStream.end(() => {
  console.log("Data written to fruits.txt successfully.\n");

  // 2. Create a Readable Stream -> Read fruits.txt
  const readStream = fs.createReadStream(fruitsFile, { encoding: "utf8" });

  readStream.on("data", chunk => {
    const lines = chunk.trim().split("\n");
    lines.forEach(line => {
      let fruit = JSON.parse(line);
      console.log(`Fruit ID: ${fruit.id}`);
      console.log(`Name: ${fruit.name}`);
      console.log(`Color: ${fruit.color}`);
      console.log(`Price: ${fruit.price}\n`);
    });
  });

  readStream.on("end", () => {
    console.log("Finished reading fruits.txt\n");

    // 3. Pipe Streams -> Copy fruits.txt to fruits_copy.txt
    const source = fs.createReadStream(fruitsFile);
    const destination = fs.createWriteStream(fruitsCopyFile);

    source.pipe(destination);

    destination.on("finish", () => {
      console.log("Content copied to fruits_copy.txt using pipe.");
    });
  });

  readStream.on("error", err => {
    console.error("Error reading file:", err);
  });
});
