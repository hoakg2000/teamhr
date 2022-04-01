package com.tma.teamhr.service.impl;

import com.tma.teamhr.model.Skill;
import com.tma.teamhr.repository.ISkillRepository;
import com.tma.teamhr.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tma.teamhr.utils.message;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillService implements ISkillService {

    @Autowired
    private ISkillRepository skillRepository;

    @Override
    public Skill getById(int id) throws NullPointerException{
        Optional<Skill> optionalSkill = skillRepository.findById(id);
        if (optionalSkill.isEmpty())
            throw new NullPointerException(message.NOTEXIST_ID);
        return optionalSkill.get();
    }

    @Override
    public List<Skill> getAll() {
        Iterable<Skill> skillIterable = skillRepository.findAll();
        List<Skill> skillList = new ArrayList<>();
        skillIterable.forEach(skillList::add);
        return skillList;
    }

    @Override
    public Skill create(Skill skill) throws SQLIntegrityConstraintViolationException{
        List<Skill> skillList = getAll();
        for (Skill skill1 : skillList) {
            if (skill1.getName().equals(skill.getName())){
                throw new SQLIntegrityConstraintViolationException(skill.toString() + " Already exist!!!");
            }
        }
        skillRepository.save(skill);
        return skill;
    }

    @Override
    public Skill update(Skill skill){
        skillRepository.save(skill);
        return skill;
    }

    @Override
    public Boolean delete(int id){
        try {
            getById(id);
        }catch (NullPointerException ex){
            throw new NullPointerException(ex.getMessage());
        }
        skillRepository.deleteById(id);
        return true;
    }
}
