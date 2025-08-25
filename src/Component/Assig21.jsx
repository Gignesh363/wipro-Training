import React, { useState } from "react";

function Parent() {
  const [fruits, setFruits] = useState(["Apple", "Mango"]);
  const [selectedFruit, setSelectedFruit] = useState("");

  // child B adds Orange to parent
  const addFruit = (fruit) => {
    setFruits([...fruits, fruit]);
  };

  // child A selects fruit
  const handleSelect = (fruit) => {
    setSelectedFruit(fruit);
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h2>React – Parent / Child / Sibling Communication</h2>

      {/* Child A */}
      <ChildA fruits={fruits} onSelect={handleSelect} />

      {/* Child B */}
      <ChildB sendFruit={addFruit} />

      {/* Child C */}
      <ChildC selected={selectedFruit} />
    </div>
  );
}

// Child A – displays fruit list from parent
function ChildA({ fruits, onSelect }) {
  return (
    <div style={{ marginBottom: "20px" }}>
      <h3>Fruit List</h3>
      <ul>
        {fruits.map((fruit, i) => (
          <li key={i} onClick={() => onSelect(fruit)} style={{ cursor: "pointer" }}>
            {fruit}
          </li>
        ))}
      </ul>
      <small>(Click a fruit to select it)</small>
    </div>
  );
}

// Child B – sends a fruit back to parent
function ChildB({ sendFruit }) {
  return (
    <div style={{ marginBottom: "20px" }}>
      <h3>Sender</h3>
      <button onClick={() => sendFruit("Orange")}>Send Fruit</button>
    </div>
  );
}

// Child C – shows selected fruit (from Child A)
function ChildC({ selected }) {
  return (
    <div>
      <h3>Selected Fruit</h3>
      <p>{selected ? selected : "No fruit selected"}</p>
    </div>
  );
}

export default Parent;
