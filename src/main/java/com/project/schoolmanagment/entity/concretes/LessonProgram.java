package com.project.schoolmanagment.entity.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.schoolmanagment.entity.enums.Day;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LessonProgram implements Serializable {

    //What is Serializable/Deserializable

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Day day;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "US")
    private LocalTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "US")
    private LocalTime stopTime;

    @ManyToMany
    @JoinTable(
            name = "lessonprogram_lesson_table",
            joinColumns = @JoinColumn(name = "lessonprogram_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private Set<Lesson> lesson;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private EducationTerm educationTerm;

    //CTRL+SHIFT+F --> searching. This is the most powerful/wider search in IntelliJ
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToMany(mappedBy = "lessonsProgramList", fetch = FetchType.EAGER)
    private Set<Teacher> teachers;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToMany(mappedBy = "lessonsProgramList", fetch = FetchType.EAGER)
    private Set<Student> students;

    @PreRemove
    private void removeLessonProgramFromStudent(){
        teachers.forEach(teacher -> teacher.getLessonsProgramList().remove(this));
        students.forEach(student -> student.getLessonsProgramList().remove(this));
    }

}
