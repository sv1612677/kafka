package com.zalopay.gameplay.receptionist.constant;

public enum ResponseMessage {
    MESSAGE_SUCCES("Game processing please wait"),
    MESSAGE_FAIL("Invalid user step or game play");

    private String value;
    private ResponseMessage(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
