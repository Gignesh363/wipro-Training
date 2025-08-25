import React, { useState, useEffect } from "react";

function FestivalApp() {
  const [festival, setFestival] = useState("Diwali");
  const [countdown, setCountdown] = useState(10);

  // Q1. Festival Greeting (Every Render)
  useEffect(() => {
    console.log("Festival App Rendered");
  });

  // Q2. Welcome Message (Run Once)
  useEffect(() => {
    alert("Welcome to Diwali Festival App");
  }, []);

  // Q3. Festival Change Tracker (Dependency Example)
  useEffect(() => {
    console.log(`Festival changed to ${festival}`);
  }, [festival]);

  // Q4. Countdown Timer (Cleanup Example)
  useEffect(() => {
    const timer = setInterval(() => {
      setCountdown((prev) => (prev > 0 ? prev - 1 : 0));
    }, 1000);

    return () => {
      clearInterval(timer);
      console.log("Timer cleared");
    };
  }, []);

  // Q5. Multiple Dependencies
  useEffect(() => {
    console.log(`Festival: ${festival}, Countdown: ${countdown}`);
  }, [festival, countdown]);

  return (
    <div className="container mt-4">
      <h2>🎉 Festival App</h2>
      <p>
        Current Festival: <b>{festival}</b>
      </p>
      <p>
        Countdown: <b>{countdown}</b>
      </p>

      <button
        className="btn btn-primary me-2"
        onClick={() => setFestival("Holi")}
      >
        Change to Holi
      </button>
      <button
        className="btn btn-success me-2"
        onClick={() => setFestival("Pongal")}
      >
        Change to Pongal
      </button>
      <button
        className="btn btn-warning"
        onClick={() => setFestival("Diwali")}
      >
        Reset to Diwali
      </button>
    </div>
  );
}

export default FestivalApp;
