package com.tma.teamhr.repository;

import com.tma.teamhr.model.Checklist;
import com.tma.teamhr.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChecklistRepository extends CrudRepository<Checklist, Integer> {
    List<Checklist> findByteam(Team id);
}
