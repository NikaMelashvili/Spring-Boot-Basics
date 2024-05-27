package com.exam.nikolozmelashvili.repositories;

import com.exam.nikolozmelashvili.model.entity.LoggingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingRepository extends JpaRepository<LoggingEntity, Integer> {
}
