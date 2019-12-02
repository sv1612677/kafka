package com.zalopay.gameplay.gameplay.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameResult {
    private String userName;
    private String gameType;
    private int userStep;
    private int botStep;
    private int result;
    public GameResult(){
        this.gameType = "123GamePlay";
    }
}
