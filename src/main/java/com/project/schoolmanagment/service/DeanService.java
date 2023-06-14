package com.project.schoolmanagment.service;

import com.project.schoolmanagment.payload.request.DeanRequest;
import com.project.schoolmanagment.payload.response.DeanResponse;
import com.project.schoolmanagment.payload.response.ResponseMessage;
import com.project.schoolmanagment.utils.FieldControl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeanService {

    AdminService adminService;

    private final FieldControl fieldControl;

    public ResponseMessage<DeanResponse> save(DeanRequest deanRequest){
        fieldControl.checkDuplicate(deanRequest.getUsername(), deanRequest.getSsn(), deanRequest.getPhoneNumber());
        return null;
    }
}
