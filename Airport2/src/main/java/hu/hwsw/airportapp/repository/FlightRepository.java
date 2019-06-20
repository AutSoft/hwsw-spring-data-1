package hu.hwsw.airportapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.hwsw.airportapp.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	
}
