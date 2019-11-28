package com.zalopay.gameplay.receptionist.service;

import com.zalopay.gameplay.receptionist.constant.GameType;
import com.zalopay.gameplay.receptionist.constant.Gesture;
import com.zalopay.gameplay.receptionist.constant.ResponseMessage;
import com.zalopay.gameplay.receptionist.constant.TopicType;
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
    TopicManagement topicManagement;

    @Autowired
    ResponsService responsService;

    @Transactional
    public ResponseEntity<Object> ValidateAndSendRequestGame123(RequestGame123 requestGame123){
        Integer gameType = requestGame123.getGameType();
        boolean isGameExist = GameType.isExistGameType(gameType);
        if(!isGameExist){
            return responsService.createRequestFail();
        }
        boolean isTypeUserPlayExist = Gesture.isExistTypeUserPlay(requestGame123.getUserStep());
        if(!isTypeUserPlayExist){
            return responsService.createRequestFail();
        }
        TopicType topicOfGameType = topicManagement.getTopicOfGameType(gameType);
        if(topicOfGameType == null){
            return responsService.createRequestFail();
        }
        producerRequestGame123.sendRequestGame123(requestGame123,topicOfGameType);
        return responsService.createRequestSuccesful();
    }

}
