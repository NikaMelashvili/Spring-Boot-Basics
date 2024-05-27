package com.exam.nikolozmelashvili.repositories;

import com.exam.nikolozmelashvili.model.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

    City getCityById(Integer id);
}
