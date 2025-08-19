import React, { Component } from "react";

// Functional Component to display the list
function TelevisionList({ models }) {                    //Display UI 
  return (
    <div>
      <h3>Television Models</h3>
      <ul>
        {models.map((model, index) => (
          <li key={index}>{model}</li>
        ))}
      </ul>
    </div>
  );
}

// 1.Class Component to manage input and state
class TelevisionManager extends Component {
  constructor(props) {
    super(props);
    this.state = {
      models: [],
      newModel: ""
    };
  }

  handleChange = (e) => {
    this.setState({ newModel: e.target.value });            // form handling
  };

  addModel = () => {
    if (this.state.newModel.trim() !== "") {
      this.setState({
        models: [...this.state.models, this.state.newModel],
        newModel: ""
      });
    }
  };

  render() {
    return (
      <div>
        <h2>Television Manager</h2>
        <input
          type="text"
          value={this.state.newModel}
          onChange={this.handleChange}
          placeholder="Enter TV model"
        />
        <button onClick={this.addModel}>Add Model</button>
        
       
        <TelevisionList models={this.state.models} />
      </div>
    );
  }
}

export default TelevisionManager;
