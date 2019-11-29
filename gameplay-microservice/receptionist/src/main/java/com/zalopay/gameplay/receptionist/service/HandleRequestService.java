package com.zalopay.gameplay.receptionist.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zalopay.gameplay.receptionist.constant.GameType;
import com.zalopay.gameplay.receptionist.constant.UserStep;
import com.zalopay.gameplay.receptionist.model.RequestGame123;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HandleRequestService {

    @Autowired
    ProducerRequestGame123 producerRequestGame123;

    @Autowired
    ResponsService responsService;

    @Transactional
    public ResponseEntity<Object> ValidateAndSendRequestGame123(RequestGame123 requestGame123){
        //check request play game wrong type or wrong structure
        if(requestGame123 == null){
            return responsService.processRequestGame123Fail();
        }
        // check hame type have exist
        GameType gameType = GameType.valueof(requestGame123.getGameType());
        boolean isGameExist = GameType.isExistGameType(gameType);
        if(!isGameExist){
            return responsService.processRequestGame123Fail();
        }
        //check request have true game type
        boolean isTypeUserPlayExist = UserStep.isExistTypeUserPlay(requestGame123.getUserStep());
        if(!isTypeUserPlayExist){
            return responsService.processRequestGame123Fail();
        }
        // send request to service 123 game play
        String topic = gameType.getTopic();
        try{
            producerRequestGame123.sendRequestGame123(requestGame123,topic);
        }catch (JsonProcessingException json){
            return responsService.processRequestGame123Fail();
        }
        return responsService.processRequestGame123Succes();
    }

}
