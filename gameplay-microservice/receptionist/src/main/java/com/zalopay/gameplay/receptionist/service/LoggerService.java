package com.zalopay.gameplay.receptionist.service;

import com.zalopay.gameplay.receptionist.controller.HandleRequestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    private final Logger loggerController = LoggerFactory.getLogger(HandleRequestController.class);
    private final Logger loggerRequestGame123 = LoggerFactory.getLogger(HandleRequestService.class);
    private final Logger loggerResponse = LoggerFactory.getLogger(ResponseServiceImpl.class);

    public void HaveNewRequest(String message){
        loggerController.info(message);
    }
    public void ResponseToClient(String message){
        loggerResponse.info(message);
    }
    public void CallVerifyServiceGame123(String message){
        loggerRequestGame123.info(message);
    }

}
