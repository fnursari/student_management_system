package com.project.schoolmanagment.service;

import com.project.schoolmanagment.entity.concretes.Lesson;
import com.project.schoolmanagment.exception.ConflictException;
import com.project.schoolmanagment.exception.ResourceNotFoundException;
import com.project.schoolmanagment.payload.mappers.LessonDto;
import com.project.schoolmanagment.payload.request.LessonRequest;
import com.project.schoolmanagment.payload.response.LessonResponse;
import com.project.schoolmanagment.payload.response.ResponseMessage;
import com.project.schoolmanagment.repository.LessonRepository;
import com.project.schoolmanagment.utils.Messages;
import com.project.schoolmanagment.utils.ServiceHelpers;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    private final LessonDto lessonDto;

    private final ServiceHelpers serviceHelpers;

    public ResponseMessage<LessonResponse> saveLesson(LessonRequest lessonRequest){

        isLessonExistByLessonName(lessonRequest.getLessonName());

        Lesson savedLEsson = lessonRepository.save(lessonDto.mapLessonRequestToLesson(lessonRequest));

        return ResponseMessage.<LessonResponse>builder()
                .object(lessonDto.mapLessonToLessonResponse(savedLEsson))
                .message("Lesson Created Successfully")
                .httpStatus(HttpStatus.CREATED)
                .build();

    }

    public ResponseMessage<LessonResponse> deleteLessonById(Long id){

        isLessonExistById(id);
        lessonRepository.deleteById(id);

        return ResponseMessage.<LessonResponse>builder()
                .message("Lesson is deleted successfully")
                .httpStatus(HttpStatus.OK)
                .build();
    }

    public ResponseMessage<LessonResponse> getLessonByLessonName(String lessonName){
        return ResponseMessage.<LessonResponse>builder()
                .message("Lesson is successfully found")
                .object(lessonDto.mapLessonToLessonResponse(lessonRepository.getLessonByLessonName(lessonName).get()))
                .httpStatus(HttpStatus.OK)
                .build();
    }

    public Page<LessonResponse> findLessonByPage(int page, int size, String sort, String type){
        Pageable pageable = serviceHelpers.getPageableWithProperties(page,size,sort,type);
        return lessonRepository.findAll(pageable).map(lessonDto::mapLessonToLessonResponse);
    }

    public Set<Lesson> getLessonByLessonIdSet(Set<Long> lessons){
        return lessonRepository.getLessonByLessonIdList(lessons);
    }

    private boolean isLessonExistByLessonName(String lessonName){
        boolean lessonExist = lessonRepository.existsLessonByLessonNameEqualsIgnoreCase(lessonName);
        if(lessonExist){
            throw new ConflictException(String.format(Messages.ALREADY_REGISTER_LESSON_MESSAGE,
                    lessonName));
        } else{
            return false;
        }
    }


    private void isLessonExistById(Long id){
        lessonRepository.findById(id).orElseThrow(
                ()->{
                    throw new ResourceNotFoundException(String.format(Messages.NOT_FOUND_LESSON_MESSAGE,id));
                }
        );
    }
}
