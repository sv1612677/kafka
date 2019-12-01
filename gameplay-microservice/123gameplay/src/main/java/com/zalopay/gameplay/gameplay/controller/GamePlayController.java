package com.zalopay.gameplay.gameplay.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zalopay.gameplay.gameplay.constant.UserStep;
import com.zalopay.gameplay.gameplay.model.GamePlay;
import com.zalopay.gameplay.gameplay.service.game.ProcessGameService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class GamePlayController {

    @PostMapping(value = "/games/1/verify",consumes = {MediaType.APPLICATION_JSON_VALUE} ,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity checkExistUserStep(@RequestBody GamePlay gamePlay) {
        if(UserStep.isExistTypeUserPlay(gamePlay.getUserStep())){
            return new ResponseEntity("success", HttpStatus.OK);
        }
        return new ResponseEntity("fail",HttpStatus.BAD_REQUEST);
    }

}
