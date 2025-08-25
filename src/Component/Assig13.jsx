import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

// Class Component for Marriage Form
class MarriageForm extends Component {
  constructor(props) {
    super(props);

    // Initial state for form fields and submitted flag
    this.state = {
      brideName: "",      // stores bride name
      groomName: "",      // stores groom name
      marriageDate: "",   // stores selected date
      venue: "",          // stores venue
      submitted: false    // flag to check whether form is submitted
    };
  }

  // Method to handle input changes (updates state dynamically)
  handleChange = (e) => {
    // [e.target.name] makes it dynamic → it updates the correct field
    this.setState({ [e.target.name]: e.target.value });
  };

  // Method to handle form submit
  handleSubmit = (e) => {
    e.preventDefault();          // Prevents page reload on submit
    this.setState({ submitted: true }); // Sets submitted flag true
  };

  render() {
    return (
      <div className="container mt-5">
        {/* Card for Form */}
        <div className="card p-4">
          <h2 className="text-center">Marriage Form</h2>

          {/* ---------- Form starts here ---------- */}
          <form onSubmit={this.handleSubmit}>
            
            {/* Bride Name Input */}
            <div className="form-group mb-3">
              <label>Bride Name</label>
              <input
                type="text"
                name="brideName"                     // mapped with state
                value={this.state.brideName}         // controlled component
                onChange={this.handleChange}         // updates state on typing
                className="form-control"
                placeholder="Enter Bride Name"
                required
              />
            </div>

            {/* Groom Name Input */}
            <div className="form-group mb-3">
              <label>Groom Name</label>
              <input
                type="text"
                name="groomName"
                value={this.state.groomName}
                onChange={this.handleChange}
                className="form-control"
                placeholder="Enter Groom Name"
                required
              />
            </div>

            {/* Marriage Date Input */}
            <div className="form-group mb-3">
              <label>Marriage Date</label>
              <input
                type="date"
                name="marriageDate"
                value={this.state.marriageDate}
                onChange={this.handleChange}
                className="form-control"
                required
              />
            </div>

            {/* Venue Input */}
            <div className="form-group mb-3">
              <label>Venue</label>
              <input
                type="text"
                name="venue"
                value={this.state.venue}
                onChange={this.handleChange}
                className="form-control"
                placeholder="Enter Venue"
                required
              />
            </div>

            {/* Submit Button */}
            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
          {/* ---------- Form ends here ---------- */}
        </div>

        {/* If form is submitted, show Marriage Details */}
        {this.state.submitted && (
          <div className="card p-4 mt-4">
            <h3 className="text-center">Marriage Details</h3>
            <p><strong>Bride Name:</strong> {this.state.brideName}</p>
            <p><strong>Groom Name:</strong> {this.state.groomName}</p>
            <p><strong>Date:</strong> {this.state.marriageDate}</p>
            <p><strong>Venue:</strong> {this.state.venue}</p>
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm;
