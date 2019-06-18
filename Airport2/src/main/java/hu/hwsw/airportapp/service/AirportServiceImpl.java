package hu.hwsw.airportapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import hu.hwsw.airportapp.web.dto.airport.AirportDTO;
import hu.hwsw.airportapp.web.dto.airport.NewAirportDTO;

@Service
public class AirportServiceImpl implements AirportService {

	private List<AirportDTO> airports = new ArrayList<>();
	private Long nextId = 10L;
	
	@PostConstruct
	public void init() {
		airports.add(new AirportDTO(1L, LocalDateTime.now(), LocalDateTime.now(), "Budapest Airport", "BUD"));
		airports.add(new AirportDTO(2L, LocalDateTime.now(), LocalDateTime.now(), "Barcelona Airport", "BCN"));
		airports.add(new AirportDTO(3L, LocalDateTime.now(), LocalDateTime.now(), "San Francisco Airport", "SFO"));
	}
	
	@Override
	public List<AirportDTO> getAirports(String iata, Pageable pageable) {
		
		if (StringUtils.isEmpty(iata)) {
			return airports
					.stream()
					.skip(pageable.getOffset())
					.limit(pageable.getPageSize())
					.collect(Collectors.toList());
		} else {
			return airports
					.stream()
					.filter(a -> a.getIata().equals(iata))
					.collect(Collectors.toList());
		}
		
	}

	@Override
	public AirportDTO createAirport(NewAirportDTO newAirport) {
		AirportDTO airport = new AirportDTO(nextId++, 
				LocalDateTime.now(), LocalDateTime.now(),
				newAirport.getName(), newAirport.getIata());
		
		airports.add(airport);
		
		return airport;
	}

}
