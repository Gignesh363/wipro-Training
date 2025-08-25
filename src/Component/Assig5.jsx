import { useState } from "react";

function Assig5(){
    const[name,setName]=useState("Laptop")
    const[brand,SetBrand]=useState("Dell")
    const[price,setPrice]=useState(69000)
    
    function changeBrand(){
        const Brandeee=prompt("Give me Brand Name")
        SetBrand(Brandeee)
    }
    function changePrice(){
        setPrice(price+1000)
    }

    return(
        <div>
            <h1>5.Electronic Iteam Details</h1>
            <h3>Name:-{name}</h3>
            <h3 >Brand:-{brand}</h3>
            <h3 >Price:-{price}</h3>
            <button onClick={changeBrand}> Change Brand</button>
            <button onClick={changePrice}> cahnge price</button>
        </div>
    )
}
export default Assig5