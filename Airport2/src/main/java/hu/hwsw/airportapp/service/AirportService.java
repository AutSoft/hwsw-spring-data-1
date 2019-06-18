package hu.hwsw.airportapp.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import hu.hwsw.airportapp.web.dto.airport.AirportDTO;
import hu.hwsw.airportapp.web.dto.airport.NewAirportDTO;

public interface AirportService {

	List<AirportDTO> getAirports(String iata, Pageable pageable);

	AirportDTO createAirport(NewAirportDTO newAirport);
}
