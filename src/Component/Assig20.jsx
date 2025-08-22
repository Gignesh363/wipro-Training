import React, { useState, useEffect } from "react";

function Restauranthandle() {
  const [formData, setFormData] = useState({
    restaurantName: "",
    ownerName: "",
    email: "",
    contactNumber: "",
    address: "",
    cuisineType: "",
    openingHours: "",
  });

  const [submittedData, setSubmittedData] = useState(null);

  // 🟢 useEffect 1: Runs on every render
  useEffect(() => {
    console.log("Component rendered!");
  });

  // 🟢 useEffect 2: Runs only once on mount
  useEffect(() => {
    console.log("Welcome to Restaurant Registration 🏨");
  }, []);

  // 🟢 useEffect 3: Runs whenever formData changes
  useEffect(() => {
    console.log("Form Data Changed:", formData);
  }, [formData]);

  // 🟢 useEffect 4: Auto-save every 5 seconds
  useEffect(() => {
    const interval = setInterval(() => {
      console.log("Auto-Saving Form Data:", formData);
    }, 5000);

    return () => clearInterval(interval); // cleanup
  }, [formData]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setSubmittedData(formData);
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h2>🍴 Restaurant Registration Form</h2>
      <p>Welcome to Restaurant Registration 🏨</p>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="restaurantName"
          placeholder="Restaurant Name"
          value={formData.restaurantName}
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="text"
          name="ownerName"
          placeholder="Owner Name"
          value={formData.ownerName}
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="email"
          name="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="text"
          name="contactNumber"
          placeholder="Contact Number"
          value={formData.contactNumber}
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="text"
          name="address"
          placeholder="Address"
          value={formData.address}
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="text"
          name="cuisineType"
          placeholder="Cuisine Type"
          value={formData.cuisineType}
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="text"
          name="openingHours"
          placeholder="Opening Hours"
          value={formData.openingHours}
          onChange={handleChange}
        />
        <br /><br />

        <button type="submit">Submit</button>
      </form>

      {submittedData && (
        <div style={{ marginTop: "20px" }}>
          <h3>📄 Submitted Data (JSON):</h3>
          <pre>{JSON.stringify(submittedData, null, 2)}</pre>
        </div>
      )}
    </div>
  );
}

export default Restauranthandle;
