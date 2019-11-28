package com.zalopay.gameplay.receptionist.service;

import com.zalopay.gameplay.receptionist.constant.GameType;
import com.zalopay.gameplay.receptionist.constant.TopicType;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class TopicManagement {

    Hashtable<GameType, TopicType> listTopic = new Hashtable<>();

    private TopicManagement(){
        listTopic.put(GameType.GAME123,TopicType.GAME_123);
    }
    public TopicType getTopicOfGameType(Integer gameType){
        GameType game = GameType.valueof(gameType);
        if(listTopic.containsKey(game)){
            return listTopic.get(game);
        }
        return null;
    }
}
