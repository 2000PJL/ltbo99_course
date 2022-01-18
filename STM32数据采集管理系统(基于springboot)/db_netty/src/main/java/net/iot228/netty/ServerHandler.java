package net.iot228.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import net.iot228.entity.TbData;
import net.iot228.entity.TbEquState;
import net.iot228.service.TbDataService;
import net.iot228.service.TbEquStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;


/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 11:54 2021/5/20
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Slf4j
@Component
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Autowired
    private TbDataService dataService;

    @Autowired
    private TbEquStateService equipStateService;
    private static ServerHandler serverHandler;
    private static final String START_FLAG = "#";
    private static final String END_FLAG = "$";
     /**
     * 配合@Component注解获取service层的bean
     */
    @PostConstruct
    public void init() {
        serverHandler = this;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        NettyServer.channel = ctx.channel();
        equipOnline(1);
        System.out.println("link " + ctx.channel() + " established......");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取客户端的IP
        InetSocketAddress inSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String ip = inSocket.getAddress().getHostAddress();
        String str = msg.toString();
        System.out.println("系统采集数据--->" + msg);
        String[] data = str.split(",");

        if (START_FLAG.equals(data[0]) && END_FLAG.equals(data[data.length - 1])) {
            TbData tbData = new TbData();
            tbData.setTemp(Float.parseFloat(data[1]));
            tbData.setHum(Float.parseFloat(data[2]));
           // tbData.setredLight(Float.parseFloat(data[3]));
            tbData.setIp(ip);
            //插入数据
            serverHandler.dataService.tbData(tbData);
        }
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        equipOffline(1);
        System.out.println("break link " + ctx.channel() + "......");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close().sync();
        log.error("channel error =>" + cause);
    }

    void equipOnline(int id){
        TbEquState equipState = new TbEquState();
        equipState.setOnline(true);
        equipState.setId(id);
        serverHandler.equipStateService.updateEquipState(equipState);
    }

    void equipOffline(int id){
        TbEquState equipState = new TbEquState();
        equipState.setOnline(false);
        equipState.setId(id);
        serverHandler.equipStateService.updateEquipState(equipState);
    }
}
