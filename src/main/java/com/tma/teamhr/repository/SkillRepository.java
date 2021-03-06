package com.tma.teamhr.repository;

import com.tma.teamhr.model.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill, Integer> {
    List<Skill> findByName(String name);
    List<Skill> findByNameAndIdNot(String name, int id);
}
