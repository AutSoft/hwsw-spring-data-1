package hu.hwsw.airportapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import hu.hwsw.airportapp.web.dto.airport.AirportDTO;
import hu.hwsw.airportapp.web.dto.airport.NewAirportDTO;

public class AirportServiceImplTest {
	
private AirportService airportService;
	
	@BeforeEach
	void setup() {
		this.airportService = new AirportServiceImpl();
	}
	
	@Test
	void createAirport() {
		NewAirportDTO newAirport = new NewAirportDTO("Budapest", "BUD");
		
		AirportDTO airportSaved = airportService.createAirport(newAirport);
		
		assertEquals(newAirport.getName(), airportSaved.getName());
		assertEquals(newAirport.getIata(), airportSaved.getIata());
		assertNotNull(airportSaved.getModifiedAt());
		assertNotNull(airportSaved.getCreatedAt());
		assertNotNull(airportSaved.getId());
	}

}
