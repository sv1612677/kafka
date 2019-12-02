package com.zalopay.gameplay.gameplay.service.game;


import com.zalopay.gameplay.gameplay.constant.UserStep;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.zalopay.gameplay.gameplay.constant.UserStep.*;

@Service
public class ProcessGameService {
    public static final int WIN = 0;
    public static final int LOSE = 1;
    public static final int DRAW = 2;
    private final Random botStep = new Random();


    public UserStep getBotStep(){
        Integer newBotStep = botStep.nextInt(3);
        UserStep userStep = UserStep.valueOf(newBotStep);
        System.out.println(userStep);
        return userStep;
    }


    public int getResultGame(UserStep userStep, UserStep botStep){
        switch (userStep){
            case ROCK:
                switch (botStep){
                    case SCISSORS: return WIN;
                    case ROCK: return DRAW;
                    case PAPER: return LOSE;
                }
            case PAPER:
                switch (botStep){
                    case ROCK: return WIN;
                    case PAPER: return DRAW;
                    case SCISSORS: return LOSE;
                }

            case SCISSORS:
                switch (botStep){
                    case PAPER: return WIN;
                    case SCISSORS: return DRAW;
                    case ROCK: return LOSE;
                }
            default: return LOSE;
        }


    }



}
