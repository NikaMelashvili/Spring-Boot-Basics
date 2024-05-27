package com.exam.nikolozmelashvili.services;

import com.exam.nikolozmelashvili.model.entity.Flight;
import com.exam.nikolozmelashvili.model.entity.dto.FlightDTO;
import com.exam.nikolozmelashvili.model.entity.mapper.FlightMapper;
import com.exam.nikolozmelashvili.repositories.CityRepository;
import com.exam.nikolozmelashvili.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final CityRepository cityRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, CityRepository cityRepository) {
        this.flightRepository = flightRepository;
        this.cityRepository = cityRepository;
    }

    public List<FlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream()
                .map(FlightMapper::flightToDto)
                .collect(Collectors.toList());
    }

    public FlightDTO getFlight(Integer id){
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found"));
        return FlightMapper.flightToDto(flight);
    }

    public void saveFlight(FlightDTO dto){
        Flight flight = FlightMapper.dtoToFlight(dto);
        flightRepository.save(flight);
    }

    public void updateFlight(FlightDTO dto, Integer id){
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found"));
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setCity(cityRepository.findById(dto.getCity())
                .orElseThrow(() -> new IllegalArgumentException("City not found")));
        flightRepository.save(flight);
    }

    public void deleteFlight(Integer id){
        flightRepository.deleteById(id);
    }
}
