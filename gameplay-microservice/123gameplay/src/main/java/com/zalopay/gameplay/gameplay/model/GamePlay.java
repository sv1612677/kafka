package com.zalopay.gameplay.gameplay.model;

import com.zalopay.gameplay.gameplay.constant.UserStep;
import lombok.*;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GamePlay {
    private String userName;
    private UserStep userStep;

}
