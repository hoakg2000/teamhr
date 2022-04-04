package com.tma.teamhr.repository;

import com.tma.teamhr.model.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISkillRepository  extends CrudRepository<Skill, Integer> {

    List<Skill> getByName(String name);
}
