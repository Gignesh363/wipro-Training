import React, { createContext, useState } from "react";

// Create context
export const PowerCutContext = createContext();

// Provider Component
export const PowerCutProvider = ({ children }) => {
  const [announcements, setAnnouncements] = useState([]);

  // Add announcement function
  const addAnnouncement = (street, message) => {
    const newAnnouncement = {
      id: Date.now(),
      street,
      message,
      time: new Date().toLocaleTimeString(),
    };
    // Add at top
    setAnnouncements([newAnnouncement, ...announcements]);
  };

  return (
    <PowerCutContext.Provider value={{ announcements, addAnnouncement }}>
      {children}
    </PowerCutContext.Provider>
  );
};
