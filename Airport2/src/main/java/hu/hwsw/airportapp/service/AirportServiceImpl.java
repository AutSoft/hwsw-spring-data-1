package hu.hwsw.airportapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import hu.hwsw.airportapp.mapper.AirportMapper;
import hu.hwsw.airportapp.model.Airport;
import hu.hwsw.airportapp.repository.AirportRepository;
import hu.hwsw.airportapp.web.dto.airport.AirportDTO;
import hu.hwsw.airportapp.web.dto.airport.NewAirportDTO;

@Service
public class AirportServiceImpl implements AirportService {
	
	@Autowired
	AirportRepository airportRepository;

	@Override
	public List<Airport> getAirports(String iata, Pageable pageable) {
		
		if (StringUtils.isEmpty(iata)) {
			return airportRepository.findAll(pageable).getContent();
		} else {
			return airportRepository.findByIata(iata, pageable).getContent();
		}
		
	}

	@Override
	public Airport createAirport(NewAirportDTO newAirport) {
		Airport airport = new Airport();
		airport.setCreatedAt(LocalDateTime.now());
		airport.setModifiedAt(LocalDateTime.now());
		airport.setIata(newAirport.getIata());
		airport.setName(newAirport.getName());
		return airportRepository.save(airport);
	}
	
	@Override
	public Airport getAirportById(Long id) {
		Optional<Airport> airportOptional = airportRepository.findById(id);

		if (airportOptional.isEmpty()) {
			throw new NoSuchElementException(String.format("Airport not found with id %d", id));
		}

		return airportOptional.get();
	}

	@Override
	@Transactional
	public Airport updateAirport(Long id, NewAirportDTO newAirport) {
		Airport airport = getAirportById(id);
		airport.setModifiedAt(LocalDateTime.now());
		AirportMapper.INSTANCE.updateFromDto(newAirport, airport);
		return airport;
	}

}
