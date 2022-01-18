package com.iot310.datacoll.entity;

import lombok.Data;

/**
 * @author TanXY
 * @date 2021/4/28 - 18:45
 */
@Data
public class CollData {

    private long id;

    private int areaId;

    private String area;

    private float light;

    private float temp;

    private float hum;

    private float soil;

    private float sound;

    private String ip;

    private String collTime;

}
