package com.project.schoolmanagment.repository;

import com.project.schoolmanagment.entity.concretes.Teacher;
import com.project.schoolmanagment.entity.concretes.ViceDean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    boolean existsByUsername(String username);

    boolean existsBySsn(String ssn);

    boolean existsByPhoneNumber(String phoneNumber);

    Teacher findByUsernameEquals(String username);

    boolean existsByEmail(String email);

    List<Teacher> getTeachersByNameContaining(String teacherName);

    Teacher getTeachersByUsername(String userName);
}
