package hu.hwsw.airportapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import hu.hwsw.airportapp.model.Airport;
import hu.hwsw.airportapp.web.dto.airport.AirportDTO;
import hu.hwsw.airportapp.web.dto.airport.NewAirportDTO;

@Mapper
public interface AirportMapper {

	AirportMapper INSTANCE = Mappers.getMapper(AirportMapper.class);
	
	AirportDTO airportToDto(Airport airport);
	
	void updateFromDto(NewAirportDTO dto, @MappingTarget Airport airport);
}
