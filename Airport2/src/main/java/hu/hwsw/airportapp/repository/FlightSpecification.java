package hu.hwsw.airportapp.repository;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;

import hu.hwsw.airportapp.model.Flight;

public class FlightSpecification implements Specification<Flight> {

	private Flight flight;

	public FlightSpecification(Flight flight) {
		this.flight = flight;
	}

	@Override
	public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		Predicate predicate = QueryByExamplePredicateBuilder.getPredicate(root, cb, 
				Example.of(flight,
						ExampleMatcher.matching()
							.withIgnoreCase()
							.withIgnoreNullValues()
							.withTransformer("capacity", v -> v.isEmpty() || (int)v.get() <=0 ? Optional.empty() : v)
							.withTransformer("averageDelay", v -> v.isEmpty() || (double)v.get() <=0 ? Optional.empty() : v)
							.withIgnorePaths("flightTime")
			)
		);
		
		int flightTime = flight.getFlightTime();
		if(flightTime > 0)
			predicate = cb.and(predicate, cb.between(root.get("flightTime"), flightTime-1, flightTime+1));
		
		return predicate;
	}

}
