import React, { useRef, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap

function UncontrolledFlightForm() {
  // Using useRef for uncontrolled components
  const flightNumberRef = useRef();
  const sourceRef = useRef();
  const destinationRef = useRef();
  const termsRef = useRef();

  // State to display submitted details
  const [details, setDetails] = useState(null);

  // Handle Submit
  const handleSubmit = (e) => {
    e.preventDefault(); // Prevents refresh

    // Directly access values from refs
    const data = {
      flightNumber: flightNumberRef.current.value,
      source: sourceRef.current.value,
      destination: destinationRef.current.value,
      terms: termsRef.current.checked,
    };

    setDetails(data); // Save details to show below
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-3">Uncontrolled Flight Booking Form</h2>
      <form onSubmit={handleSubmit} className="p-3 border rounded shadow-sm">
        {/* Flight Number */}
        <div className="mb-3">
          <label className="form-label">Flight Number</label>
          <input type="text" className="form-control" ref={flightNumberRef} />
        </div>

        {/* Source */}
        <div className="mb-3">
          <label className="form-label">Source</label>
          <input type="text" className="form-control" ref={sourceRef} />
        </div>

        {/* Destination */}
        <div className="mb-3">
          <label className="form-label">Destination</label>
          <input type="text" className="form-control" ref={destinationRef} />
        </div>

        {/* Terms Accepted */}
        <div className="form-check mb-3">
          <input
            type="checkbox"
            className="form-check-input"
            id="termsCheck"
            ref={termsRef}
          />
          <label className="form-check-label" htmlFor="termsCheck">
            Terms Accepted
          </label>
        </div>

        {/* Submit */}
        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>

      {/* Show Flight Details */}
      {details && (
        <div className="card mt-4">
          <div className="card-body">
            <h4 className="card-title">Flight Details</h4>
            <p className="card-text">
              <strong>Flight Number:</strong> {details.flightNumber}
            </p>
            <p className="card-text">
              <strong>Source:</strong> {details.source}
            </p>
            <p className="card-text">
              <strong>Destination:</strong> {details.destination}
            </p>
          </div>
        </div>
      )}
    </div>
  );
}

export default UncontrolledFlightForm;
