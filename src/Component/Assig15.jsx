import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
                                                          
function BakingItemsForm() {         //   Functional component
  const [formData, setFormData] = useState({
    itemName: "",
    quantity: "",
    ingredients: "",
    bakingTime: "",
    category: "Cake",
  });

  const [items, setItems] = useState([]);
                  
  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    if (
      formData.itemName &&
      formData.quantity &&
      formData.ingredients &&
      formData.bakingTime
    ) {
      setItems([...items, formData]); // add new item
      setFormData({
        itemName: "",
        quantity: "",
        ingredients: "",
        bakingTime: "",
        category: "Cake",
      }); // reset form
    }
  };

  return (
    <div className="container mt-5">
      <div className="card p-4 shadow-lg">
        <h3 className="mb-3">Baking Items Form</h3>

        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label className="form-label">Item Name</label>
            <input  type="text" className="form-control" name="itemName"  value={formData.itemName} onChange={handleChange} />
          </div>

          <div className="mb-3">
            <label className="form-label">Quantity</label>
            <input type="number"className="form-control" name="quantity" value={formData.quantity} onChange={handleChange}/>
          </div>

          <div className="mb-3">
            <label className="form-label">Ingredients</label>
            <input type="text" className="form-control"  name="ingredients" value={formData.ingredients} onChange={handleChange} />
          </div>

          <div className="mb-3">
            <label className="form-label">Baking Time (minutes)</label>
            <input type="text" className="form-control" name="bakingTime" value={formData.bakingTime} onChange={handleChange} />
          </div>

          <div className="mb-3">
            <label className="form-label">Category</label>
            <select className="form-control" name="category" value={formData.category} onChange={handleChange}>
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

          <button type="submit" className="btn btn-success">
            Add Baking Item
          </button>
        </form>
      </div>

      {/* Table */}
      {items.length > 0 && (
        <div className="mt-5">
          <h4>Baking Items List</h4>
          <table className="table table-striped table-bordered mt-3">
            <thead className="table-dark">
              <tr>
                <th>#</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Ingredients</th>
                <th>Baking Time</th>
                <th>Category</th>
              </tr>
            </thead>
            <tbody>
              {items.map((item, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{item.itemName}</td>
                  <td>{item.quantity}</td>
                  <td>{item.ingredients}</td>
                  <td>{item.bakingTime}</td>
                  <td>{item.category}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default BakingItemsForm;
