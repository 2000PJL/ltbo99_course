package net.iot228.controller;

import net.iot228.entity.TbData;
import net.iot228.mapper.TbDataMapper;
import net.iot228.service.TbDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.management.Sensor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 15:40 2021/5/20
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Controller
public class TbDataController {
    @Autowired
    TbDataService tbDataService;

    @Autowired
    TbDataMapper tbDataMapper;


    //@GetMapping("/index")
    @RequestMapping("/index")
    public String hello(ModelMap modelMap)
    {
        List<TbData> tbData=getCollDataList(1,30);
        modelMap.addAttribute("message",tbData);
        return "index";
    }

    /**
     * 描述：默认界面为login
     *
     * @return 登陆界面
     */

    @RequestMapping("/")
    public String toLogin()
    {
        return "login";
    }

    @GetMapping("/wlmm")
    public String toforgotpwd()
    {
        return "wlmm";
    }

    @GetMapping("/wlmm1")
    public String wlmm1()
    {
        return "wlmm1";
    }
    @GetMapping("/chart")
    public String chart(ModelMap modelMap)
    {
        List<TbData> tbData=getCollDataList(1,20);
        modelMap.addAttribute("value",tbData);
        return "chart";
    }

    @GetMapping("/getCollDataList")
    @ResponseBody
    public List<TbData> getCollDataList(int page, int size) {
        return tbDataService.selectTbDataList(page, size);
    }


    @GetMapping("/getCollDataCount")
    @ResponseBody
    public int getCollDataCount(){
        return tbDataService.countCollData();
    }



    @GetMapping("/getCollDataList1")
    @ResponseBody
    public List<TbData> baseData(ModelMap modelMap)
    {
        return tbDataMapper.selectTbDataList(0,20);
    }

    @GetMapping("/chart1")
    private  String chart() {
        return "chart1";
    }

//    //@GetMapping("/index1")
    @GetMapping("/index1")
    public String toforgot()
    {
        return "index1";
    }

    @RequestMapping("/allSensor")
    @ResponseBody
    public Map<String,Object> getAllData()
    {
        List<TbData> datas = tbDataMapper.selectTbDataList(0,100);
        int counts = datas.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", counts);
        map.put("data", datas);
        System.out.println(counts);
        return map;
    }

}