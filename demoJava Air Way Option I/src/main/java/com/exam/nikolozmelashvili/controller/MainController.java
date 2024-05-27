package com.exam.nikolozmelashvili.controller;

import com.exam.nikolozmelashvili.model.entity.dto.CityDTO;
import com.exam.nikolozmelashvili.model.entity.dto.FlightDTO;
import com.exam.nikolozmelashvili.services.CityService;
import com.exam.nikolozmelashvili.services.FlightService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final CityService cityService;

    private final FlightService flightService;

    @Autowired
    public MainController(CityService cityService, FlightService flightService) {
        this.cityService = cityService;
        this.flightService = flightService;
    }

    // city section
    @GetMapping("/city")
    public ResponseEntity<List<CityDTO>> getAllCities(){
        List<CityDTO> dto = cityService.getAllCities();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<CityDTO> getCity(@PathVariable Integer id){
        CityDTO dto = cityService.getCity(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/city")
    public ResponseEntity<Void> saveCity(@RequestBody CityDTO dto){
        cityService.saveCity(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/city/update/{id}")
    public ResponseEntity<Void> updateCity(@RequestBody CityDTO dto,
                                         @PathVariable Integer id){
        cityService.updateCity(dto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/city/delete/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Integer id){
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // flight section
    @GetMapping("/flight/{id}")
    public ResponseEntity<List<FlightDTO>> getAllFlights(){
        List<FlightDTO> flightDTOList = flightService.getAllFlights();
        return new ResponseEntity<>(flightDTOList, HttpStatus.OK);
    }

    @GetMapping("/flight")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable Integer id){
        FlightDTO dto = flightService.getFlight(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/flight")
    public ResponseEntity<Void> saveFlight(@RequestBody FlightDTO dto){
        flightService.saveFlight(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/flight/update/{id}")
    public ResponseEntity<Void> updateFlight(@PathVariable Integer id,
                                             @RequestBody FlightDTO flightDTO){
        flightService.updateFlight(flightDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/flight/delete/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer id){
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
