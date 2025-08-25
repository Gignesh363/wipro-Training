import React from "react";
import { Link } from "react-router-dom";

function NavbarComponent() {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container">
        <Link className="navbar-brand" to="/">Income Tax Department</Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav me-auto">
            <li className="nav-item"><Link className="nav-link" to="/">Home</Link></li>
            <li className="nav-item"><Link className="nav-link" to="/add-taxpayer">Add Taxpayer</Link></li>
            <li className="nav-item"><Link className="nav-link" to="/taxpayer-list">Taxpayer List</Link></li>
            <li className="nav-item"><Link className="nav-link" to="/calculate-tax">Calculate Tax</Link></li>
            <li className="nav-item"><Link className="nav-link" to="/tax-rates">Tax Rates</Link></li>
            <li className="nav-item"><Link className="nav-link" to="/contact">Contact</Link></li>
            <li className="nav-item"><Link className="nav-link" to="/about">About</Link></li>
            <li className="nav-item"><Link className="nav-link" to="/faq">FAQ</Link></li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default NavbarComponent;
