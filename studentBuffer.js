// 1. Create a Buffer of size 256 bytes
let buffer = Buffer.alloc(256);

// Student object
let student = {
  id: 1,
  name: "Thanmaya",
  age: 20,
  grade: "A"
};

// Convert student object to JSON string
let studentStr = JSON.stringify(student);

// 2. Write Data to Buffer
let bytesWritten = buffer.write(studentStr, "utf8");
console.log("Bytes written to buffer:", bytesWritten);

// 3. Read Data from Buffer
let bufferContent = buffer.toString("utf8", 0, bytesWritten);
console.log("Buffer content as string:", bufferContent);

// Parse back to object
let parsedStudent = JSON.parse(bufferContent);
console.log("Parsed Student Data:");
console.log("Id:", parsedStudent.id);
console.log("Name:", parsedStudent.name);
console.log("Age:", parsedStudent.age);
console.log("Grade:", parsedStudent.grade);

// 4. Buffer Operations
// Append another student if space permits
let student2 = { id: 2, name: "John", age: 22, grade: "B" };
let student2Str = JSON.stringify(student2);

// Write at position after first student data
let bytesWritten2 = buffer.write(student2Str, bytesWritten, "utf8");
console.log("\nBytes written for 2nd student:", bytesWritten2);

// Read full buffer content
let allData = buffer.toString("utf8", 0, bytesWritten + bytesWritten2);
console.log("Buffer content after adding 2nd student:", allData);

// Slice buffer (only first student record)
let slicedBuffer = buffer.slice(0, bytesWritten);
console.log("Sliced Buffer Data:", slicedBuffer.toString("utf8"));

// Copy data from one buffer to another
let newBuffer = Buffer.alloc(256);
slicedBuffer.copy(newBuffer, 0, 0, slicedBuffer.length);
console.log("Copied Buffer Data:", newBuffer.toString("utf8"));

// 5. Encoding & Decoding
console.log("\nEncoding Demonstrations:");

// UTF-8
console.log("UTF-8:", buffer.toString("utf8", 0, bytesWritten));

// ASCII
console.log("ASCII:", buffer.toString("ascii", 0, bytesWritten));

// Base64
console.log("Base64:", buffer.toString("base64", 0, bytesWritten));
