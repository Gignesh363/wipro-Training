import React, { useState, useEffect } from "react";

function FestivalApp() {
  const [festival, setFestival] = useState("Diwali");
  const [countdown, setCountdown] = useState(10);

  // Q1: Festival Greeting (Every Render) → No dependency array
  useEffect(() => {
    console.log("Festival App Rendered");
  });

  // Q2: Welcome Message (Run Once) → Empty dependency []
  useEffect(() => {
    alert("Welcome to Diwali Festival App");
  }, []);

  // Q3: Festival Change Tracker (Dependency Example)
  useEffect(() => {
    console.log(`Festival changed to ${festival}`);
  }, [festival]);

  // Q4: Countdown Timer (Cleanup Example)
  useEffect(() => {
    const timer = setInterval(() => {
      setCountdown((prev) => (prev > 0 ? prev - 1 : 0));
    }, 1000);

    // cleanup when component unmounts
    return () => clearInterval(timer);
  }, []);

  // Q5: Multiple Dependencies (festival OR countdown changes)
  useEffect(() => {
    console.log(`Festival: ${festival}, Countdown: ${countdown}`);
  }, [festival, countdown]);

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h1>🎉 Festival React App 🎉</h1>
      <h2>Current Festival: {festival}</h2>
      <h3>Countdown: {countdown}</h3>

      {/* Buttons to change festival */}
      <button onClick={() => setFestival("Diwali")}>Diwali</button>
      <button onClick={() => setFestival("Holi")}>Holi</button>
      <button onClick={() => setFestival("Pongal")}>Pongal</button>
    </div>
  );
}

export default FestivalApp;
