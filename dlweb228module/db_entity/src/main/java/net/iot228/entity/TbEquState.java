package net.iot228.entity;

import lombok.Data;

/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 11:19 2021/5/20
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Data
public class TbEquState {
    private long id;

    private boolean led1;

    private boolean led2;

    private boolean led3;

    private boolean beep;

    private boolean dht11;

    private boolean light;

    private boolean online;

}
