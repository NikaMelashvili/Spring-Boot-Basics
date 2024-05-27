package com.exam.nikolozmelashvili.services;

import com.exam.nikolozmelashvili.model.entity.City;
import com.exam.nikolozmelashvili.model.entity.dto.CityDTO;
import com.exam.nikolozmelashvili.model.entity.mapper.CityMapper;
import com.exam.nikolozmelashvili.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityDTO> getAllCities() {
        List<City> cities = (List<City>) cityRepository.findAll();
        return cities.stream()
                .map(CityMapper::cityToDto)
                .collect(Collectors.toList());
    }

    public CityDTO getCity(Integer id){
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("City not found"));
        return CityMapper.cityToDto(city);
    }

    public void saveCity(CityDTO dto){
        City city = CityMapper.dtoToCity(dto);
        cityRepository.save(city);
    }

    public void updateCity(CityDTO dto, Integer id){
        City city = cityRepository.getCityById(id);
        city.setName(dto.getName());
        city.setPopulation(dto.getPopulation());
        cityRepository.save(city);
    }

    public void deleteCity(Integer id){
        cityRepository.deleteById(id);
    }
}
