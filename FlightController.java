package com.example.demo.resources;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flight;

import com.example.demo.repository.FlightRepository;

import exception.BusinessException;

@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightRepository flightrepository;

	@PostMapping("/addFlight")
	public String saveFlight(@RequestBody Flight flightid) {
		flightrepository.save(flightid);
		return "Added flight with id :  " + flightid.getFlightid();
	}

	@GetMapping("{flightid}")
	public Optional<Flight> getFlight(@PathVariable String flightid) {
		Optional<Flight> flight=flightrepository.findById(flightid);
		if(!flight.isPresent()) {
			throw new BusinessException("Flight is not found with "+flightid);
		}
		return flightrepository.findById(flightid);
	}
	

	@DeleteMapping("/delete/{flightid}")
	public String deleteFlight(@PathVariable String flightid) {
		if(flightrepository.existsById(flightid)) {
			flightrepository.deleteById(flightid);
		}else {
			throw new BusinessException("No Flight is found in "+flightid+" Id");
		}
	
		return "Flight deleted with id : " + flightid;
	}

	@PutMapping("/update/{flightid}")
	public Object updateFlight(@PathVariable("flightid") String flightid, @RequestBody Flight f) {
		Optional<Flight> list=flightrepository.findById(flightid);
		if(!list.isPresent()) {
			throw new BusinessException("Flight With Id "+flightid+" is not present");
		}else {
			flightrepository.deleteById(flightid);
			flightrepository.save(f);
		}
	
		return "Flight Updated with :"+f.getFlightid();

	}
}
