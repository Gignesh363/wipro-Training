import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";


function ServiceCard({ service }) {
  return (
    <div className="col-md-3 mb-4">
      <div className="card h-100 shadow-lg border-primary">
        <div className="card-body">
          <h5 className="card-title text-center">{service.serviceName}</h5>
          <p className="card-text">
            <strong>Price:</strong>{" "}
            <span className="text-primary">${service.price}</span>
          </p>
          <p><strong>Fabrics:</strong></p>
          <ul className="list-unstyled">
            {service.fabricsAvailable.map((fabric, index) => (
              <li key={index}>- {fabric}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
}

// Parent Component → TailorShop
function TailorShop() {
  // JSON Array of tailoring services
  const tailoringServices = [
    {
      serviceName: "Shirt",
      price: 20,
      fabricsAvailable: ["Cotton", "Linen", "Polyester"],
    },
    {
      serviceName: "Pants",
      price: 30,
      fabricsAvailable: ["Denim", "Wool", "Chino"],
    },
    {
      serviceName: "Lehenga",
      price: 150,
      fabricsAvailable: ["Silk", "Georgette", "Chiffon"],
    },
    {
      serviceName: "Blouse",
      price: 40,
      fabricsAvailable: ["Cotton", "Silk", "Satin"],
    },
  ];

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Tailoring Services</h2>
      <div className="row">
        {tailoringServices.map((service, index) => (
          <ServiceCard key={index} service={service} />
        ))}
      </div>
    </div>
  );
}

export default TailorShop;
