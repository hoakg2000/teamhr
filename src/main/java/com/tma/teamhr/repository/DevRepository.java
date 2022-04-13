package com.tma.teamhr.repository;

import com.tma.teamhr.model.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface DevRepository extends JpaRepository<Dev, Integer> {
}
