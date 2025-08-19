function Assig2(props){ // props will come from in app.js we kept elements in element tag we pass there it will passes here as props

    return(
      <div>
         <h1>Assignment 2</h1>
         <ol>
        <li>{props.brand}</li>
        <li>{props.model}</li>
        <li>{props.color}</li>
        <li>{props.year}</li>
      
      </ol>
      </div>
      
    )
}
export default Assig2