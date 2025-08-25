import React, { Component } from "react";


function FruitList({ fruits }) {
  return (
    <div>
      <h3>FruitList</h3>
      <ul>
        {fruits.map((fruit, index) => (
          <li key={index}>{fruit}</li>
        ))}
      </ul>
    </div>
  );
}


class Fruits extends Component {                      //1. Class component
  constructor(props) {
    super(props);
    this.state = {
      fruits: ["Apple", "Banana", "Orange"],
      newFruit: ""
    };
  }


  handleChange = (e) => {
    this.setState({ newFruit: e.target.value });
  };

  
  addFruit = () => {
    if (this.state.newFruit.trim() !== "") {
      this.setState((prevState) => ({
        fruits: [...prevState.fruits, prevState.newFruit],
        newFruit: ""
      }));
    }
  };

  render() {
    return (
      <div style={{ margin: "20px" }}>
        <h2>Fruits</h2>
        <input
          type="text"
          value={this.state.newFruit}
          onChange={this.handleChange}
          placeholder="Enter a fruit"
        />
        <button onClick={this.addFruit}>Add</button>

    
        <FruitList fruits={this.state.fruits} />
      </div>
    );
  }
}

export default Fruits;
