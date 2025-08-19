import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

class MovieForm extends Component {
  constructor(props) {
    super(props);
    console.log("constructor executed");

    // Component state holds all form fields + movies list
    this.state = {
      title: "",          // Movie title
      director: "",       // Director name
      year: "",           // Release year
      genre: "Action",    // Default genre
      rating: "",         // Movie rating (1-5)
      description: "",    // Movie description
      platforms: [],      // Selected OTT platforms
      movies: [],         // List of added movies
    };
  }

  // React Lifecycle Methods
  static getDerivedStateFromProps(props, state) {
    console.log("getDerivedStateFromProps executed");
    return null; // No state updates from props
  }

  componentDidMount() {
    console.log("componentDidMount executed"); // Called after initial render
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate executed");
    return true; // Allow re-render
  }

  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("getSnapshotBeforeUpdate executed");
    return null;
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log("componentDidUpdate executed");
  }

  componentWillUnmount() {
    console.log("componentWillUnmount executed");
  }

  // Handle input changes (text, number, radio, checkbox, etc.)
  handleChange = (e) => {
    const { name, value, type, checked } = e.target;

    // Special case: if input type is checkbox (for OTT platforms)
    if (type === "checkbox") {
      let platforms = [...this.state.platforms];

      if (checked) {
        platforms.push(value); // Add platform if checked
      } else {
        platforms = platforms.filter((item) => item !== value); // Remove if unchecked
      }

      this.setState({ platforms });
    } else {
      // For other input fields (text, number, select, radio)
      this.setState({ [name]: value });
    }
  };

  // Handle form submission
  handleSubmit = (e) => {
    e.preventDefault(); // Prevent page refresh

    const { title, director, year, genre, rating, description, platforms } =
      this.state;

    // Create a new movie object
    const newMovie = {
      title,
      director,
      year,
      genre,
      rating,
      description,
      platforms: platforms.join(", "), // Convert array to string
    };

    // Update movies list and reset form fields
    this.setState((prevState) => ({
      movies: [...prevState.movies, newMovie], // Add new movie to list
      title: "",
      director: "",
      year: "",
      genre: "Action",
      rating: "",
      description: "",
      platforms: [], // Reset checkboxes
    }));
  };

  render() {
    console.log("render executed");

    return (
      <div className="container mt-4">
        {/* Movie Form Card */}
        <div className="card p-4 shadow">
          <h3 className="mb-3">Add Movie</h3>

          {/* Form Starts */}
          <form onSubmit={this.handleSubmit}>
            
            {/* Movie Title */}
            <div className="mb-3">
              <label className="form-label">Movie Title</label>
              <input
                type="text"
                className="form-control"
                name="title"
                value={this.state.title}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Director */}
            <div className="mb-3">
              <label className="form-label">Director</label>
              <input
                type="text"
                className="form-control"
                name="director"
                value={this.state.director}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Release Year */}
            <div className="mb-3">
              <label className="form-label">Release Year</label>
              <input
                type="number"
                className="form-control"
                name="year"
                value={this.state.year}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Genre Dropdown */}
            <div className="mb-3">
              <label className="form-label">Genre</label>
              <select
                className="form-select"
                name="genre"
                value={this.state.genre}
                onChange={this.handleChange}
              >
                <option>Action</option>
                <option>Comedy</option>
                <option>Drama</option>
                <option>Sci-Fi</option>
                <option>Horror</option>
              </select>
            </div>

            {/* Rating (Radio Buttons) */}
            <div className="mb-3">
              <label className="form-label">Rating</label>
              <div>
                {[1, 2, 3, 4, 5].map((num) => (
                  <div className="form-check form-check-inline" key={num}>
                    <input
                      className="form-check-input"
                      type="radio"
                      name="rating"
                      value={num}
                      checked={this.state.rating === String(num)}
                      onChange={this.handleChange}
                    />
                    <label className="form-check-label">{num}</label>
                  </div>
                ))}
              </div>
            </div>

            {/* Description */}
            <div className="mb-3">
              <label className="form-label">Description</label>
              <textarea
                className="form-control"
                name="description"
                value={this.state.description}
                onChange={this.handleChange}
              ></textarea>
            </div>

            {/* Streaming Platforms (Checkboxes) */}
            <div className="mb-3">
              <label className="form-label">Available on Streaming Platforms</label>
              {["Netflix", "Amazon Prime", "Disney+", "Hotstar"].map((platform) => (
                <div className="form-check" key={platform}>
                  <input
                    className="form-check-input"
                    type="checkbox"
                    value={platform}
                    checked={this.state.platforms.includes(platform)}
                    onChange={this.handleChange}
                  />
                  <label className="form-check-label">{platform}</label>
                </div>
              ))}
            </div>

            {/* Submit Button */}
            <button type="submit" className="btn btn-primary">
              Add Movie
            </button>
          </form>
        </div>

        {/* Movie Table */}
        {this.state.movies.length > 0 && (
          <div className="mt-4">
            <h4>Movie List</h4>
            <table className="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Director</th>
                  <th>Release Year</th>
                  <th>Genre</th>
                  <th>Rating</th>
                  <th>Available on Streaming Platforms</th>
                </tr>
              </thead>
              <tbody>
                {this.state.movies.map((movie, index) => (
                  <tr key={index}>
                    <td>{movie.title}</td>
                    <td>{movie.director}</td>
                    <td>{movie.year}</td>
                    <td>{movie.genre}</td>
                    <td>{movie.rating}</td>
                    <td>{movie.platforms}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default MovieForm;
