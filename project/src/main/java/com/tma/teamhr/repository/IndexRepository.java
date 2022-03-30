package com.tma.teamhr.repository;

import com.tma.teamhr.pojos.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexRepository extends JpaRepository<CheckList,Long> {

    @Query(value = "select * from checklist",
            nativeQuery = true)
    CheckList getCheckListById(int id);
}
