package com.zalopay.gameplay.receptionist.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zalopay.gameplay.receptionist.constant.GameType;
import com.zalopay.gameplay.receptionist.constant.ResponseMessage;
import com.zalopay.gameplay.receptionist.model.RequestGame123;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HandleRequestService {

    @Autowired
    ProducerRequestGame123 producerRequestGame123;

    @Autowired
    VerifyRequestGame123Service verifyRequestGame123Service;

    @Autowired
    ResponsService responsService;

    @Autowired
    LoggerService loggerService;

    public ResponseEntity<Object> ValidateAndSendRequestGame123(RequestGame123 requestGame123){
        //check request play game wrong type or wrong structure
        if(requestGame123 == null){
            loggerService.ResponseToClient(ResponseMessage.RESPONSE_MESSAGE_GAME123_FAIL.getMessage());
            return responsService.processRequestGame123Fail();
        }
        loggerService.CallVerifyServiceGame123("Verify Request by call controller of service game 123");
        boolean isCorrect = verifyRequestGame123Service.isCorrectRequestPlayGame123(requestGame123);
        if(!isCorrect){
            loggerService.ResponseToClient(ResponseMessage.RESPONSE_MESSAGE_GAME123_FAIL.getMessage());
            return responsService.processRequestGame123Fail();
        }
        // send request to service 123 game play
        try{
            producerRequestGame123.sendRequestGame123(requestGame123,GameType.GAME123.getTopic());
        }catch (JsonProcessingException json){
            loggerService.ResponseToClient(ResponseMessage.RESPONSE_MESSAGE_GAME123_FAIL.getMessage());
            return responsService.processRequestGame123Fail();
        }
        loggerService.ResponseToClient(ResponseMessage.RESPONSE_MESSAGE_GAME123_SUCCESS.getMessage());
        return responsService.processRequestGame123Succes();
    }

}
