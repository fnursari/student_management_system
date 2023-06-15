package com.project.schoolmanagment.repository;

import com.project.schoolmanagment.entity.concretes.Student;
import com.project.schoolmanagment.entity.concretes.ViceDean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    boolean existsByUsername(String username);

    boolean existsBySsn(String ssn);

    boolean existsByPhoneNumber(String phoneNumber);

    Student findByUsernameEquals(String username);

    boolean existsByEmail(String email);
}
