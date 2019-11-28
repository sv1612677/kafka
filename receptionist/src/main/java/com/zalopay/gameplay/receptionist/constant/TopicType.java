package com.zalopay.gameplay.receptionist.constant;

import java.util.HashMap;
import java.util.Map;

public enum  TopicType {

    GAME_123("game123");
    private final String value;

    TopicType(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
