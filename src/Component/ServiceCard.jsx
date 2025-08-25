import React from "react";

function ServiceCard({ service }) {
  return (
    <div className="col-md-3 mb-4">
      <div className="card shadow-sm h-100">
        <div className="card-body">
          <h5 className="card-title">{service.serviceName}</h5>
          <p className="card-text text-primary">Price: ${service.price}</p>
          <h6>Fabrics:</h6>
          <ul>
            {service.fabricsAvailable.map((fabric, index) => (
              <li key={index}>{fabric}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
}

export default ServiceCard;
