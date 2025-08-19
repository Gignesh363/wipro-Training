function Assig1(){
    var Gr=["Rice", "Wheat", "Sugar", "Milk", "Oil"]
     return(
       <div>
        <h1>Assignment 1</h1>
         {
            Gr.map((m,n)=>{              // bascic map function(it is a firstclass function m will store elements and n will store index)
            return(<ul>
                <li key={n}>{m}</li>
                </ul>
            )

        })
         }
       </div>
     )
}
export default Assig1