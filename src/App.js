// App.js
import React from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

// Assignments
import Assig1 from "./Component/Assi1";
import Assig2 from "./Component/Assig2";
import Assig3 from "./Component/Assig3";
import Assi4 from "./Component/Assi4";
import Assig5 from "./Component/Assig5";

// Components
import CanteenMenu from "./Component/CanteenMenu";
import JuiceList from "./Component/JuiceList";
import Restaurant from "./Component/Restaurant";
import TempleList from "./Component/TempleList";
import TailorShop from "./Component/TailorShop";
import Fruits from "./Component/Assig11";
import TelevisionManager from "./Component/Assig12";
import MarriageForm from "./Component/Assig13";
import AccessoriesForm from "./Component/Assig14";
import BakingItemsForm from "./Component/Assig15";
import ControlledFlightForm from "./Component/FlightControlledForm";
import UncontrolledFlightForm from "./Component/FlightUncontrolledForm";
import MovieForm from "./Component/Assig17";
import FestivalApp from "./Component/FestivalApp";
import Restauranthandle from "./Component/Assig20";
import Parent from "./Component/Assig21";
import FurnitureStore from "./Component/Furniture";
import ChessTournamentForm from "./Component/Assig22";
import HockeyTournamentForm from "./Component/Assig23";
import TailoringInventory from "./Component/Assig24";
import MainPlayer from "./Component/PlayerManagerrs";

// Context
import { PowerCutProvider } from "./context/PowerCutContext";

// Announcement features
import SendAnnouncement from "./Component/SendAnnouncement";
import AnnouncementList from "./Component/AnnouncementList";

function App() {
  return (
    <div>
      {/* Assignment Components */}
      <Assig1 />
      <Assig2 brand="Toyota" model="Fortuner" color="Black" year="2022" />
      <Assig3 />
      <Assi4 />
      <Assig5 />

      {/* Other Components */}
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
      <FestivalApp />
      <Restauranthandle />
      <Parent />
      <FurnitureStore />
      <ChessTournamentForm />
      <HockeyTournamentForm />
      <TailoringInventory />
      <MainPlayer />

      {/* Context Example */}
      <PowerCutProvider>
        <div className="container mt-4">
          <SendAnnouncement />
          <AnnouncementList />
        </div>
      </PowerCutProvider>
    </div>
  );
}

export default App;
