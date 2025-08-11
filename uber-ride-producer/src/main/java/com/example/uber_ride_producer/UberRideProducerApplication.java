package com.example.uber_ride_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UberRideProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberRideProducerApplication.class, args);
	}

}
//HTTP Method	URL	Description	Body (JSON)
//1.POST	
//http://localhost:8080/rides                	Create a new ride	Full Ride JSON (without id)

//{
//	  "id": 1,
//	  "passengerName": "John Doe",
//	  "pickupLocation": "Location A",
//	  "dropLocation": "Location B",
//	  "operation": "CREATE"
//	}



////2.PUT	http://localhost:8080/rides/{id}   -
///{
//"passengerName": "Alice Updated",
//"pickupLocation": "New Location",
//"dropLocation": "New Drop"
//}
//	Update ride by id	Full Ride JSON (without id or with changes)




////3.DELETE	http://localhost:8080/rides/{id}	Delete ride by id	No body required