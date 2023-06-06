package com.project.schoolmanagment.controller;

import com.project.schoolmanagment.payload.request.ContactMessageRequest;
import com.project.schoolmanagment.payload.response.ContactMessageResponse;
import com.project.schoolmanagment.payload.response.ResponseMessage;
import com.project.schoolmanagment.service.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("contactMessages")
@RequiredArgsConstructor
public class ContactMessageController {


    private final ContactMessageService contactMessageService;

    @PostMapping("/save")
    public ResponseMessage<ContactMessageResponse> save(@RequestBody @Valid ContactMessageRequest contactMessageRequest){
        return contactMessageService.save(contactMessageRequest);
    }

    @GetMapping("/getAll")
    public Page<ContactMessageResponse> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "date") String sort,
            @RequestParam(value = "type", defaultValue = "desc") String type){

        contactMessageService.getAll(page,size,sort,type);
        return null;
    }

}
