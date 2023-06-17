package com.project.schoolmanagment.repository;

import com.project.schoolmanagment.entity.concretes.EducationTerm;
import com.project.schoolmanagment.entity.enums.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTermRepository extends JpaRepository<EducationTerm,Long> {

    @Query("SELECT (count (e) > 0) FROM EducationTerm e WHERE e.term=?1 AND EXTRACT(YEAR FROM e.startDate) = ?2")
    boolean existsByTermAndYear(Term term, int year); //FALL_SEMESTER,2005

    @Query("SELECT educationTerm FROM EducationTerm educationTerm WHERE educationTerm.id=?1")
    EducationTerm findByIdEquals(Long id);


}
