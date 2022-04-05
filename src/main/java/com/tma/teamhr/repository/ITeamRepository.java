package com.tma.teamhr.repository;

import com.tma.teamhr.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface ITeamRepository extends CrudRepository<Team, Integer> {
}
