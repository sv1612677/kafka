package com.zalopay.gameplay.receptionist.service;

import com.zalopay.gameplay.receptionist.constant.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponsService {

    public ResponseEntity<Object> createRequestSuccesful(){
        return new ResponseEntity<>(ResponseMessage.MESSAGE_SUCCES.getValue(), HttpStatus.OK);
    }
    public ResponseEntity<Object> createRequestFail(){
        return new ResponseEntity<>(ResponseMessage.MESSAGE_FAIL.getValue(), HttpStatus.BAD_REQUEST);
    }
}
