package com.tma.teamhr.repository;

import com.tma.teamhr.model.Checklist;
import org.springframework.data.repository.CrudRepository;

public interface IChecklistRepository extends CrudRepository<Checklist, Long> {
}
