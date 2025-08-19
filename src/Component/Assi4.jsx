function Assi4(){
    const sweets = [
    { id: 1, name: "Laddu", price: 50 },
    { id: 2, name: "Jalebi", price: 40 },
    { id: 3, name: "Rasgulla", price: 60 },
    { id: 4, name: "Gulab Jamun", price: 70 }
  ];
  return(
    <div>
            <h1>Assignment-4</h1>
            
            {sweets.map((m,n)=>{
        return(
          
           <ul>
            <li>{m.name}-Price:-{m.price}</li>
           </ul>
          
        )
    })}
          </div>
    
  )
}
export default Assi4