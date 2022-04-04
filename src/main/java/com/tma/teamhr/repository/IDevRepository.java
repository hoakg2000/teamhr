package com.tma.teamhr.repository;

import com.tma.teamhr.model.Dev;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDevRepository extends CrudRepository<Dev, Integer> {
    List<Dev> findByIdNumber(String idNumber);
}
