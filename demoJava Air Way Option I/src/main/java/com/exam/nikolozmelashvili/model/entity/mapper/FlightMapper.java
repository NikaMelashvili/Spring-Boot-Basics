package com.exam.nikolozmelashvili.model.entity.mapper;

import com.exam.nikolozmelashvili.model.entity.Flight;
import com.exam.nikolozmelashvili.model.entity.City;
import com.exam.nikolozmelashvili.model.entity.dto.FlightDTO;
import com.exam.nikolozmelashvili.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {

    private static CityRepository cityRepository = null;

    @Autowired
    public FlightMapper(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public static FlightDTO flightToDto(Flight flight) {
        FlightDTO dto = new FlightDTO();

        dto.setFlightNumber(flight.getFlightNumber());
        dto.setCity(flight.getCity().getId());

        return dto;
    }

    public static Flight dtoToFlight(FlightDTO dto) {
        Flight flight = new Flight();

        flight.setFlightNumber(dto.getFlightNumber());
        City city = cityRepository.findById(dto.getCity())
                .orElseThrow(() -> new IllegalArgumentException("City not found"));
        flight.setCity(city);

        return flight;
    }
}
