package com.project.schoolmanagment.repository;

import com.project.schoolmanagment.entity.concretes.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {

    boolean existsLessonByLessonNameEqualsIgnoreCase(String lessonName);
}
