package com.iot45.entity;/*
 * @Systemname: BookShow
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  15:30 2022/1/4
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
import lombok.Data;

@Data
public class CollData {
    private long id;

    private String temp;

    private String hum;

    private String supersonic;

    private String light;

    private String colltime;

    private String address;
}
