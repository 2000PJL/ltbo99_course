package net.iot228.entity;

import lombok.Data;

/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 11:18 2021/5/20
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Data
public class TbData {
    private long id;

    private float temp;

    private float hum;

    private int redlight;

    private String ip;

    private String collTime;
}
