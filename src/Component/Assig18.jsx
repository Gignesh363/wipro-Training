import React, { useState, useEffect } from "react";

function RestaurantForm() {
  //  State to store form input values
  const [formData, setFormData] = useState({
    restaurantName: "",
    ownerName: "",
    email: "",
    contactNumber: "",
    address: "",
    cuisineType: "",
    openingHours: "",
  });

  //  State to hold submitted form data after pressing Submit button
  const [submittedData, setSubmittedData] = useState(null);

  //  useEffect 1: Runs on every render (no dependency array given)
  useEffect(() => {
    console.log("Component rendered!");
  });

  //  useEffect 2: Runs only once when the component mounts (empty dependency array [])
  useEffect(() => {
    console.log("Welcome to Restaurant Registration 🏨");
  }, []);

  //  useEffect 3: Runs whenever formData changes (dependency array [formData])
  useEffect(() => {
    console.log("Form Data Changed:", formData);
  }, [formData]);

  // useEffect 4: Auto-save functionality (runs every 5 seconds)
  useEffect(() => {
    const interval = setInterval(() => {
      console.log("Auto-Saving Form Data:", formData);
    }, 5000);

    // Cleanup function: clears interval when component unmounts OR when formData changes
    return () => clearInterval(interval);
  }, [formData]);

  //  Handles input field changes and updates state
  const handleChange = (e) => {
    const { name, value } = e.target; 
    setFormData({ ...formData, [name]: value }); // updates only the changed field
  };

  //  Handles form submission (prevents reload & saves form data into submittedData)
  const handleSubmit = (e) => {
    e.preventDefault(); 
    setSubmittedData(formData);
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h2>🍴 Restaurant Registration Form</h2>
      <p>Welcome to Restaurant Registration 🏨</p>

      {/*  Form starts here */}
      <form onSubmit={handleSubmit}>
        {/* Each input is connected to formData state */}
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

        {/* Submit button */}
        <button type="submit">Submit</button>
      </form>

      {/*  Display submitted data after form submission */}
      {submittedData && (
        <div style={{ marginTop: "20px" }}>
          <h3> Submitted Data (JSON):</h3>
          {/* Pretty print submitted data */}
          <pre>{JSON.stringify(submittedData, null, 2)}</pre>
        </div>
      )}
    </div>
  );
}

export default RestaurantForm;
