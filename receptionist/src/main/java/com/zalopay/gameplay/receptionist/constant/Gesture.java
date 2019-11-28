package com.zalopay.gameplay.receptionist.constant;

import java.util.HashMap;
import java.util.Map;

public enum  Gesture {
    ROCK (1),
    PAPER (2),
    SCISSORS (3);

    private final Integer value;

    private static Map listTypeUserPlay= new HashMap<>();

    private Gesture(final Integer value) {
        this.value = value;
    }

    static {
        for (Gesture gesture : Gesture.values()) {
            listTypeUserPlay.put(gesture.value, gesture);
        }
    }
    public static boolean isExistTypeUserPlay(Integer typeUserPlay){
        return listTypeUserPlay.containsKey(typeUserPlay);
    }
    public static Gesture valueOf(Integer typeUserPlay) {
        return (Gesture) listTypeUserPlay.get(typeUserPlay);
    }
    public Integer getValue() { return value; }
}
