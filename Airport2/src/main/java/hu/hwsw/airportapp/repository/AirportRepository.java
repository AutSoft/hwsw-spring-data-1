package hu.hwsw.airportapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.hwsw.airportapp.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long>{

}
