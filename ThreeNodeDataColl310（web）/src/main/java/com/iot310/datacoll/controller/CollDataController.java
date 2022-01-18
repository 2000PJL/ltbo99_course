package com.iot310.datacoll.controller;

import com.iot310.datacoll.entity.CollData;
import com.iot310.datacoll.service.CollDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @author TanXY
 * @date 2021/4/28 - 19:09
 */
@Controller
public class CollDataController {

    @Autowired
    CollDataService collDataService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/showChart")
    public String showChart(){
        return "chart";
    }

    @ResponseBody
    @GetMapping("/data/list")
    public HashMap<String, Object> selectDataList(int page, int limit){
        HashMap<String, Object> map = new HashMap<>(3);
        List<CollData> collData = collDataService.selectCollDataList(page, limit);
        int count = collDataService.countCollData();

        map.put("data", collData);
        map.put("count", count);
        map.put("code", 0);

        return map;
    }

}
