package com.project.schoolmanagment.repository;

import com.project.schoolmanagment.entity.concretes.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage,Long> {

    boolean existsByEmailEqualsAndDateEquals(String email, LocalDate date);
}
