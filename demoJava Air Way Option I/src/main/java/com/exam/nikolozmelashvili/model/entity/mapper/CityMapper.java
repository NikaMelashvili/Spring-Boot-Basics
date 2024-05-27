package com.exam.nikolozmelashvili.model.entity.mapper;

import com.exam.nikolozmelashvili.model.entity.City;
import com.exam.nikolozmelashvili.model.entity.dto.CityDTO;

public class CityMapper {

    public static CityDTO cityToDto(City city) {
        CityDTO dto = new CityDTO();

        dto.setId(city.getId());
        dto.setName(city.getName());

        return dto;
    }

    public static City dtoToCity(CityDTO dto) {
        City city = new City();

        city.setId(dto.getId());
        city.setName(dto.getName());

        return city;
    }
}
