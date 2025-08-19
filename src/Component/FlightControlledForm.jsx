import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css"; // ✅ Import Bootstrap CSS

function ControlledFlightForm() {
  // Using state variables for controlled inputs
  const [passengerName, setPassengerName] = useState("");
  const [email, setEmail] = useState("");
  const [gender, setGender] = useState("");
  const [meal, setMeal] = useState("Veg");
  const [request, setRequest] = useState("");
  const [submittedData, setSubmittedData] = useState([]);

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault(); // Prevents page reload
    const newEntry = { passengerName, email, gender, meal, request };
    setSubmittedData([...submittedData, newEntry]); // Store submitted data
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">✈ Controlled Flight Booking Form</h2>

      {/* Form Card */}
      <div className="card p-4 shadow-lg">
        <form onSubmit={handleSubmit}>
          {/* Passenger Name */}
          <div className="mb-3">
            <label className="form-label">Passenger Name</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter name"
              value={passengerName}
              onChange={(e) => setPassengerName(e.target.value)}
              required
            />
          </div>

          {/* Email */}
          <div className="mb-3">
            <label className="form-label">Email</label>
            <input
              type="email"
              className="form-control"
              placeholder="Enter email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>

          {/* Gender */}
          <div className="mb-3">
            <label className="form-label">Gender</label>
            <div>
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  className="form-check-input"
                  name="gender"
                  value="Male"
                  checked={gender === "Male"}
                  onChange={(e) => setGender(e.target.value)}
                />
                <label className="form-check-label">Male</label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  className="form-check-input"
                  name="gender"
                  value="Female"
                  checked={gender === "Female"}
                  onChange={(e) => setGender(e.target.value)}
                />
                <label className="form-check-label">Female</label>
              </div>
            </div>
          </div>

          {/* Meal Preference */}
          <div className="mb-3">
            <label className="form-label">Meal Preference</label>
            <select
              className="form-select"
              value={meal}
              onChange={(e) => setMeal(e.target.value)}
            >
              <option value="Veg">Veg</option>
              <option value="Non-Veg">Non-Veg</option>
            </select>
          </div>

          {/* Special Request */}
          <div className="mb-3">
            <label className="form-label">Special Request</label>
            <input
              type="text"
              className="form-control"
              placeholder="Any special request"
              value={request}
              onChange={(e) => setRequest(e.target.value)}
            />
          </div>

          {/* Submit Button */}
          <button type="submit" className="btn btn-primary w-100">
            Submit
          </button>
        </form>
      </div>

      {/* Submitted Data Table */}
      {submittedData.length > 0 && (
        <div className="mt-5">
          <h4 className="mb-3">📋 Submitted Bookings</h4>
          <table className="table table-bordered table-hover">
            <thead className="table-dark">
              <tr>
                <th>Passenger Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Meal</th>
                <th>Request</th>
              </tr>
            </thead>
            <tbody>
              {submittedData.map((row, index) => (
                <tr key={index}>
                  <td>{row.passengerName}</td>
                  <td>{row.email}</td>
                  <td>{row.gender}</td>
                  <td>{row.meal}</td>
                  <td>{row.request}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default ControlledFlightForm;
