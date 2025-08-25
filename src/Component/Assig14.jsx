import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

class AccessoriesForm extends Component {
  constructor(props) {
    super(props);
    this.state = {                                       //this.state is used to store data
      accessoryName: "",
      description: "",
      category: "",
      brand: "",
      inStock: false,
      warranty: "",
      submitted: false
    };
  }

  handleChange = (e) => {                                                     //method onclick will come to here
    const { name, value, type, checked } = e.target;
    this.setState({[name]: type === "checkbox" ? checked : value });
  };

  handleSubmit = (e) => {                                                      //method (when you click submit button it will come here)
    e.preventDefault();
    this.setState({ submitted: true });
  };

  render() {
    return (
      <div className="container mt-5">
        <div className="card p-4">
          <h2 className="text-center">Accessories Form</h2>
          <form onSubmit={this.handleSubmit}>
            {/* Text Input */}
            <div className="form-group mb-3">
              <label>Accessory Name</label>
              <input type="text"  name="accessoryName"  value={this.state.accessoryName} onChange={this.handleChange}  className="form-control"  required/>
            </div>

            {/* Textarea */}
            <div className="form-group mb-3">
              <label>Description</label>
              <textarea name="description"  value={this.state.description}  onChange={this.handleChange}  className="form-control" rows="3"  required  />
            </div>

            {/* Select Dropdown */}
            <div className="form-group mb-3">
              <label>Category</label>
              <select name="category"  value={this.state.category}
                onChange={this.handleChange}
                className="form-control"
                required
              >
                <option value="">Select Category</option>
                <option value="Electronics">Electronics</option>
                <option value="Furniture">Furniture</option>
                <option value="Clothing">Clothing</option>
              </select>
            </div>

            {/* Radio Buttons */}
            <div className="form-group mb-3">
              <label>Brand</label> <br />
              <div className="form-check form-check-inline">
                <input  type="radio" name="brand"  value="Sony"  checked={this.state.brand === "Sony"} onChange={this.handleChange} className="form-check-input"
                  required
                />
                <label className="form-check-label">Sony</label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  name="brand"
                  value="Samsung"
                  checked={this.state.brand === "Samsung"}
                  onChange={this.handleChange}
                  className="form-check-input"
                />
                <label className="form-check-label">Samsung</label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  type="radio"
                  name="brand"
                  value="LG"
                  checked={this.state.brand === "LG"}
                  onChange={this.handleChange}
                  className="form-check-input"
                />
                <label className="form-check-label">LG</label>
              </div>
            </div>

            {/* Checkbox */}
            <div className="form-group mb-3 form-check">
              <input
                type="checkbox"
                name="inStock"
                checked={this.state.inStock}
                onChange={this.handleChange}
                className="form-check-input"
              />
              <label className="form-check-label">Available in stock</label>
            </div>

            {/* Number Input */}
            <div className="form-group mb-3">
              <label>Warranty (years)</label>
              <input
                type="number"
                name="warranty"
                value={this.state.warranty}
                onChange={this.handleChange}
                className="form-control"
                min="0"
                required
              />
            </div>

            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

       
        {this.state.submitted && (                  /* Display Table */                                        //Here it will generate Table 
          <div className="card mt-4 p-4">
            <h3 className="text-center">Accessory Details</h3>
            <table className="table table-bordered mt-3">
              <tbody>
                <tr>
                  <th>Accessory Name</th>
                  <td>{this.state.accessoryName}</td>
                </tr>
                <tr>
                  <th>Description</th>
                  <td>{this.state.description}</td>
                </tr>
                <tr>
                  <th>Category</th>
                  <td>{this.state.category}</td>
                </tr>
                <tr>
                  <th>Brand</th>
                  <td>{this.state.brand}</td>
                </tr>
                <tr>
                  <th>Available in Stock</th>
                  <td>{this.state.inStock ? "Yes" : "No"}</td>
                </tr>
                <tr>
                  <th>Warranty</th>
                  <td>{this.state.warranty} years</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default AccessoriesForm;
