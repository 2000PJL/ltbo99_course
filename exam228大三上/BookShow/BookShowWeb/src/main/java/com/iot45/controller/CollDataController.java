package com.iot45.controller;/*
 * @Systemname: BookShow
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  15:47 2022/1/4
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */


import com.iot45.entity.CollData;
import com.iot45.netty.NettyServer;
import com.iot45.netty.NettyServerHandler;
import com.iot45.service.CollDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class CollDataController {
    @Autowired
    CollDataService collDataService;

    @Autowired
    NettyServerHandler nettyServer;


    @GetMapping("")
    private String index()
    {
        return "index";
    }

    @GetMapping("/chart")
    private String chart()
    {
        return "chart";
    }


    @ResponseBody
    @GetMapping("/selectAllCollData")
    public List<CollData> selectAllCollData(){
        nettyServer.sendMsg("test");
        return collDataService.selectAllCollData();
    }

    @ResponseBody
    @GetMapping("/changeLED")
    public int changeStatus(boolean status) throws IOException {
        if (status){
            nettyServer.sendMsg("#OLED$");
        } else {
            nettyServer.sendMsg("#CLED$");
        }

        return 1;
    }

    @ResponseBody
    @GetMapping("/changeBeep")
    public int changeBeep(boolean status) throws IOException {
        if (status){
            nettyServer.sendMsg("#OBEEP$");
        } else {
            nettyServer.sendMsg("#CBEEP$");
        }

        return 1;
    }

}
