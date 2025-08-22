import logo from './logo.svg';
import './App.css';
import Assig1 from './Component/Assi1';
import Assig2 from './Component/Assig2';
import Assig3 from './Component/Assig3';
import Assi4 from './Component/Assi4';
import Assig5 from './Component/Assig5';
import CanteenMenu from './Component/CanteenMenu';
import JuiceList from './Component/JuiceList';
import Restaurant from './Component/Restaurant';
import TempleList from './Component/TempleList';
import TailorShop from './Component/TailorShop';
import Fruits from './Component/Assig11';
import TelevisionManager from './Component/Assig12';
import MarriageForm from './Component/Assig13';
import AccessoriesForm from './Component/Assig14';
import BakingItemsForm from './Component/Assig15';

import ControlledFlightForm from './Component/FlightControlledForm';
import UncontrolledFlightForm from './Component/FlightUncontrolledForm';
import MovieForm from './Component/Assig17';

import React, { useState } from "react";   // ✅ keep only once
import { Bed, Chair, Table, Sofa } from './Component';
import "bootstrap/dist/css/bootstrap.min.css";
import FestivalApp from './Component/FestivalApp';
import Restauranthandle from './Component/Assig20';
import Parent from './Component/Assig21';

function App() {
  // ✅ useState must be at top level
  const [selected, setSelected] = useState("Chair");

  // ✅ no hook inside here
  const renderFurniture = () => {
    switch (selected) {
      case "Chair":
        return <Chair />;
      case "Table":
        return <Table />;
      case "Sofa":
        return <Sofa />;
      case "Bed":
        return <Bed />;
      default:
        return <p className="text-muted">Please select a furniture item.</p>;
    }
  };

  return (
    <div>
      <Assig1 />
      <Assig2 brand="Toyota" model="Fortuner" color="Black" year="2022" />
      <Assig3 />
      <Assi4 />
      <Assig5 />
      <CanteenMenu />
      <JuiceList />
      <Restaurant />
      <TempleList />
      <TailorShop />
      <Fruits />
      <TelevisionManager />
      <MarriageForm />
      <AccessoriesForm />
      <BakingItemsForm />
      <ControlledFlightForm />
      <UncontrolledFlightForm />
      <MovieForm />
      <FestivalApp></FestivalApp>
      <Restauranthandle></Restauranthandle>
      <Parent></Parent>
      <div className="container mt-4">
        <h2 className="mb-3">🏬 Furniture Store</h2>

        {/* Dropdown */}
        <select
          className="form-select w-50 mb-3"
          value={selected}
          onChange={(e) => setSelected(e.target.value)}
        >
          <option value="Chair">Chair</option>
          <option value="Table">Table</option>
          <option value="Sofa">Sofa</option>
          <option value="Bed">Bed</option>
        </select>

        {/* Dynamic Component Rendering */}
        {renderFurniture()}
      </div>
    </div>
  );
}

export default App;
