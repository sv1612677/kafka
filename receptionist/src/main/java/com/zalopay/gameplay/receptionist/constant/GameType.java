package com.zalopay.gameplay.receptionist.constant;

import java.util.HashMap;
import java.util.Map;

public enum  GameType {
    GAME123(1);

    private final Integer value;

    private static Map listGameType = new HashMap<>();

    GameType(final Integer value){
        this.value=value;
    }

    static {
        for (GameType gameType : GameType.values()) {
            listGameType.put(gameType.value, gameType);
        }
    }

    public Integer getValue() {
        return value;
    }

    public static GameType valueof(Integer value){
        GameType gameType = (GameType) listGameType.get(value);
        if (gameType == null){
            throw new IllegalArgumentException("Not Enum constant was found for value : " + value);
        }
        return gameType;
    }
    public static boolean isExistGameType(Integer gameType){
        return listGameType.containsKey(gameType);
    }
}
