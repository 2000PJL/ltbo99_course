package net.iot228.controller;

import net.iot228.entity.TbEquState;
import net.iot228.netty.NettyServer;
import net.iot228.service.TbEquStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 15:47 2021/5/20
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@RestController
public class TbEquStateController {

    @Autowired
    TbEquStateService tbequStateService;

    @GetMapping("/openLed")
    public boolean openLed(int number) {
        System.err.println(number);
        TbEquState equipState = new TbEquState();
        equipState.setId(1);
        if (number == 1) {
            equipState.setLed1(true);
        } else if(number == 2){
            equipState.setLed2(true);
        } else {
            equipState.setLed3(true);
        }
        tbequStateService.updateEquipState(equipState);
        return NettyServer.sendMsg("open_led" + number);
    }

    @GetMapping("/closeLed")
    public boolean closeLed(int number) {
        TbEquState equipState = new TbEquState();
        equipState.setId(1);
        if (number == 1) {
            equipState.setLed1(false);
        } else if(number == 2){
            equipState.setLed2(false);
        } else {
            equipState.setLed3(false);
        }
        tbequStateService.updateEquipState(equipState);
        return NettyServer.sendMsg("close_led" + number);
    }

    @GetMapping("/openBeep")
    public boolean openBeep() {
        TbEquState equipState = new TbEquState();
        equipState.setId(1);
        equipState.setBeep(true);
        tbequStateService.updateEquipState(equipState);
        return NettyServer.sendMsg("open_beep");
    }

    @GetMapping("/closeBeep")
    public boolean closeBeep() {
        TbEquState equipState = new TbEquState();
        equipState.setId(1);
        equipState.setBeep(false);
        tbequStateService.updateEquipState(equipState);
        return NettyServer.sendMsg("close_beep");
    }

    @GetMapping("/openDHT11")
    public boolean openDht11() {
        TbEquState equipState = new TbEquState();
        equipState.setId(1);
        equipState.setDht11(true);
        tbequStateService.updateEquipState(equipState);
        return NettyServer.sendMsg("open_DHT11");
    }

    @GetMapping("/closeDHT11")
    public boolean closeDht11() {
        TbEquState equipState = new TbEquState();
        equipState.setId(1);
        equipState.setBeep(false);
        tbequStateService.updateEquipState(equipState);
        return NettyServer.sendMsg("close_DHT11");
    }

    @GetMapping("/openLight")
    public boolean openLight() {
        TbEquState equipState = new TbEquState();
        equipState.setId(1);
        equipState.setLight(true);
        tbequStateService.updateEquipState(equipState);
        return NettyServer.sendMsg("open_light");
    }

    @GetMapping("/closeLight")
    public boolean closeLight() {
        TbEquState equipState = new TbEquState();
        equipState.setId(1);
        equipState.setLight(false);
        tbequStateService.updateEquipState(equipState);
        return NettyServer.sendMsg("close_light");
    }

    @GetMapping("/resetAll")
    public boolean openLed() {
        TbEquState equipState = new TbEquState();
        equipState.setId(1);
        equipState.setLight(false);
        equipState.setLed1(false);
        equipState.setLed2(false);
        equipState.setLed3(false);
        equipState.setBeep(false);
        equipState.setDht11(false);
        tbequStateService.updateEquipState(equipState);
        return NettyServer.sendMsg("reset_all");
    }

    @GetMapping("/getEquipState")
    public TbEquState getTbEquState(int id) {
        return tbequStateService.selectTbEquStateById(id);
    }
}
