import React, { useState, useContext } from "react";
import { PowerCutContext } from "../context/PowerCutContext";

const SendAnnouncement = () => {
  const { addAnnouncement } = useContext(PowerCutContext);
  const [street, setStreet] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (street && message) {
      addAnnouncement(street, message);
      setStreet("");
      setMessage("");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="p-3 border rounded bg-light mb-3">
      <h4>Street Power Cut Announcements</h4>
      
      <div className="mb-3">
        <label className="form-label">Street Name:</label>
        <input
          type="text"
          className="form-control"
          value={street}
          onChange={(e) => setStreet(e.target.value)}
          required
        />
      </div>

      <div className="mb-3">
        <label className="form-label">Message:</label>
        <textarea
          className="form-control"
          value={message}
          onChange={(e) => setMessage(e.target.value)}
          required
        />
      </div>

      <button type="submit" className="btn btn-primary">
        Send Announcement
      </button>
    </form>
  );
};

export default SendAnnouncement;
