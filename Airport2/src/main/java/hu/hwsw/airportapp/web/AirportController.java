package hu.hwsw.airportapp.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.hwsw.airportapp.service.AirportService;
import hu.hwsw.airportapp.web.dto.airport.AirportDTO;
import hu.hwsw.airportapp.web.dto.airport.NewAirportDTO;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {

	private final AirportService airportService;
	
	public AirportController(AirportService airportService) {
		this.airportService = airportService;
	}

	@GetMapping
	List<AirportDTO> getAirports(@RequestParam(name = "iata", required = false) String iata, Pageable pageable) {
		return airportService.getAirports(iata, pageable);
	}
	
	@PostMapping
	AirportDTO createAirport(@RequestBody @Valid NewAirportDTO newAirport) {
		return airportService.createAirport(newAirport);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<AirportDTO> getAirportById(@PathVariable Long id) {
	    Optional<AirportDTO> optional = airportService.getAirportById(id);
	    if (optional.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    } else {
	        return ResponseEntity.status(HttpStatus.OK).body(optional.get());
	    }
	}
}
