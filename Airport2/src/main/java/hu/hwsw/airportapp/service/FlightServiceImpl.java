package hu.hwsw.airportapp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import hu.hwsw.airportapp.model.Flight;
import hu.hwsw.airportapp.repository.AirportRepository;
import hu.hwsw.airportapp.repository.FlightRepository;
import hu.hwsw.airportapp.web.dto.flight.NewFlightDTO;
import hu.hwsw.airportapp.web.dto.flight.NewFlightWithNewAirportsDTO;

@Service
public class FlightServiceImpl implements FlightService {

    
    private AirportService airportService;
    
    private FlightRepository flightRepository;

	public FlightServiceImpl(AirportService airportService, FlightRepository flightRepository) {
		this.airportService = airportService;
		this.flightRepository = flightRepository;
	}

    
	@Override
	public Flight createFlightWithAirports(NewFlightWithNewAirportsDTO newFlightWithNewAirportsDTO) {
		//TODO: save all 3 entities
		return null;
	}


	@Override
    public Flight createFlight(@Valid NewFlightDTO newFlight) {
    	return null;
    }


    @Override
    public List<Flight> getArrivingFlightsByAirportId(Long airportId) {
    	return null;
    }

    @Override
    public List<Flight> getDepartingFlightsByAirportId(Long airportId) {
    	return null;
    }

    @Override
    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(Long id) {
        return null;
    }

    @Override
    public Flight updateFlightById(Long id, NewFlightDTO newFlight) {
    	 return null;
    }

    @Override
    public void deleteFlightById(Long id) {
    }

}
