package hu.hwsw.airportapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.hwsw.airportapp.model.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Integer>{

	Authority findByAuthority(String name); 
}
