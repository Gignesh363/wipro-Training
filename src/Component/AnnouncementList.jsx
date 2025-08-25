import React, { useContext } from "react";
import { PowerCutContext } from "../context/PowerCutContext";

const AnnouncementList = () => {
  const { announcements } = useContext(PowerCutContext);

  return (
    <div className="border p-3 rounded" style={{ maxHeight: "300px", overflowY: "auto" }}>
      <h5>Power Cut Announcements</h5>
      {announcements.length === 0 ? (
        <p>No announcements yet.</p>
      ) : (
        announcements.map((a) => (
          <div key={a.id} className="border p-2 rounded mb-2 bg-info">
            <p><strong>Street:</strong> {a.street}</p>
            <p><strong>Message:</strong> {a.message}</p>
            <p><small><strong>Time:</strong> {a.time}</small></p>
          </div>
        ))
      )}
    </div>
  );
};

export default AnnouncementList;
