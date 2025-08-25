import { useState } from "react";

function Assig3(){
const[apple,SetApple]=useState({brand:"Toyota", model:"Fortuner",price:79000}) // we use useState predefineHook
function pricee(){
    SetApple({...apple,price:apple.price+1000})// we use ...spread operator 
}
return(
    <div>
        <h1>Assignment 3</h1>
        <ul typeof="none">
        <li>{apple.brand}</li>
        <li>{apple.model}</li>
        <li>{apple.price}</li>
        <button onClick={()=>{pricee()}}>Price Increase</button> 
       
    </ul>
    </div>
    
)
}
export default Assig3;