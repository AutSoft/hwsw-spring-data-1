package hu.hwsw.airportapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Flight  {

	@Id
	@GeneratedValue
	private Long id;
    private String flightNumber;
    private int capacity;
    private int flightTime;
    private double averageDelay;

    @ManyToOne
    private Airport fromAirport;
    @ManyToOne
    private Airport toAirport;
    
    public Flight() {
        super();
    }

    public Flight(Long id, LocalDateTime createdAt, LocalDateTime modifiedAt, String flightNumber, int capacity,
                     int flightTime, double averageDelay, Airport fromAirport, Airport toAirport) {
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.flightTime = flightTime;
        this.averageDelay = averageDelay;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getFlightTime() {
        return flightTime;
    }
    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }
    public double getAverageDelay() {
        return averageDelay;
    }
    public void setAverageDelay(double averageDelay) {
        this.averageDelay = averageDelay;
    }

	public Airport getFromAirport() {
		return fromAirport;
	}

	public void setFromAirport(Airport fromAirport) {
		this.fromAirport = fromAirport;
	}

	public Airport getToAirport() {
		return toAirport;
	}

	public void setToAirport(Airport toAirport) {
		this.toAirport = toAirport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
  
    
}
