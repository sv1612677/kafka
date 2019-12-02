package com.zalopay.gameplay.receptionist.service;

import com.zalopay.gameplay.receptionist.constant.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponsService {

    @Autowired
    LoggerService loggerService;

    @Override
    public ResponseEntity<Object> processRequestGame123Succes() {
        loggerService.ResponseToClient("request play game success, send request to service game 123");
        return new ResponseEntity<>(ResponseMessage.RESPONSE_MESSAGE_GAME123_SUCCESS.getMessage(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> processRequestGame123Fail() {
        loggerService.ResponseToClient("request play game fail, invalid userStep or game type");
        return new ResponseEntity<>(ResponseMessage.RESPONSE_MESSAGE_GAME123_FAIL.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
