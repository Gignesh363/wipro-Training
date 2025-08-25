import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"; // ✅ Import Router, Routes, Route
import NavbarComponent from "./component/NavbarComponent"; // ✅ Import Navbar


import Home from "./component/Home";
import AddTaxpayer from "./component/AddTaxpayer";
import TaxpayerList from "./component/TaxpayerList";
import CalculateTax from "./component/CalculateTax";
import TaxRates from "./component/TaxRates";
import Contact from "./component/Contact";
import About from "./component/About";
import FAQ from "./component/FAQ";
import NotFound from "./component/NotFound";
function App() {
  return (
    <Router>
      <NavbarComponent />
      <div className="container mt-3">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/add-taxpayer" element={<AddTaxpayer />} />
          <Route path="/taxpayer-list" element={<TaxpayerList />} />
          <Route path="/calculate-tax" element={<CalculateTax />} />
          <Route path="/tax-rates" element={<TaxRates />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/about" element={<About />} />
          <Route path="/faq" element={<FAQ />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
