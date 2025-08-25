import React, { useState } from "react";
import Chair from "./Chair";
import Table from "./Table";
import Sofa from "./Sofa";
import Bed from "./Bed";

function FurnitureStore() {
  const [selected, setSelected] = useState("chair");

  const renderFurniture = () => {
    switch (selected) {
      case "chair":
        return <Chair />;
      case "table":
        return <Table />;
      case "sofa":
        return <Sofa />;
      case "bed":
        return <Bed />;
      default:
        return <p>Please select a furniture item.</p>;
    }
  };

  return (
    <div className="container mt-4">
      <h2>Furniture Store</h2>

      <select className="form-select w-50" value={selected} onChange={(e) => setSelected(e.target.value)}>
        <option value="chair">Chair</option>
        <option value="table">Table</option>
        <option value="sofa">Sofa</option>
        <option value="bed">Bed</option>
      </select>

      {renderFurniture()}
    </div>
  );
}

export default FurnitureStore;
