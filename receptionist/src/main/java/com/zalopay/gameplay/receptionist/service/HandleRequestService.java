package com.zalopay.gameplay.receptionist.service;

import com.zalopay.gameplay.receptionist.constant.GameType;
import com.zalopay.gameplay.receptionist.constant.Gesture;
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

        GameType gameType = GameType.valueOf(requestGame123.getGameType());
        boolean isGameExist = GameType.isExistGameType(gameType);
        if(!isGameExist){
            return responsService.processRequestGame123Fail();
        }
        boolean isTypeUserPlayExist = Gesture.isExistTypeUserPlay(requestGame123.getUserStep());
        if(!isTypeUserPlayExist){
            return responsService.processRequestGame123Fail();
        }
        String topic = gameType.getTopic();
        producerRequestGame123.sendRequestGame123(requestGame123,topic);
        return responsService.processRequestGame123Succes();
    }

}
