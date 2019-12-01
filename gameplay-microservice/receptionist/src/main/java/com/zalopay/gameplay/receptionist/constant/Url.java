package com.zalopay.gameplay.receptionist.constant;

public enum  Url {
    URL_VERIFY_REQUEST_PLAY_GAME("http://localhost:8081/games/1/verify");

    private final String url;

    Url(final String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
