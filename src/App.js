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
import ControlledForm from './Component/FlightControlledForm';
import UncontrolledForm from './Component/FlightUncontrolledForm';
import ControlledFlightForm from './Component/FlightControlledForm';
import UncontrolledFlightForm from './Component/FlightUncontrolledForm';
import MovieForm from './Component/Assig17';

function App() {
  return (
    <div >
     <Assig1></Assig1>
     <Assig2 brand="Toyota" model="Fortuner" color="Black" year="2022" ></Assig2>
     <Assig3 ></Assig3>
     <Assi4></Assi4>
     <Assig5></Assig5>
     <CanteenMenu></CanteenMenu>
     <JuiceList></JuiceList>
     <Restaurant></Restaurant>
     <TempleList></TempleList>
     <TailorShop></TailorShop>
     <Fruits></Fruits>
     <TelevisionManager></TelevisionManager>
     <MarriageForm></MarriageForm>
     <AccessoriesForm></AccessoriesForm>
     <BakingItemsForm></BakingItemsForm>
    <ControlledFlightForm></ControlledFlightForm>
    <UncontrolledFlightForm></UncontrolledFlightForm>
    <MovieForm></MovieForm>
    </div>
  );
}

export default App;
