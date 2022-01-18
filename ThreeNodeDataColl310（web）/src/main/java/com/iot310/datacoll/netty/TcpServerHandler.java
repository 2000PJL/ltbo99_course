package com.iot310.datacoll.netty;


import com.iot310.datacoll.entity.CollData;
import com.iot310.datacoll.service.CollDataService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

/**
 * @author TanXY
 * @since 2021/4/3 23:34
 */
@Slf4j
@Component
public class TcpServerHandler extends ChannelInboundHandlerAdapter {

    @Autowired
    CollDataService collDataService;

    static TcpServerHandler serverHandler;

    private static final String FRAME_HEAD = "#";

    private static final String FRAME_TAIL = "$";

    private static final int FRAME_LEN = 6;

    public TcpServerHandler() {
    }

    @PostConstruct
    public void init() {
        serverHandler = this;
        serverHandler.collDataService = this.collDataService;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = inetSocketAddress.getAddress().getHostAddress();
        System.err.println(ctx.channel());
        log.info("client【" + clientIp + "】connected......");

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = inetSocketAddress.getAddress().getHostAddress();

        String received = msg.toString();
        log.info("received data from【" + clientIp + "】==>" + received);

        String[] split = received.split(",");

        CollData collData = new CollData();
        if (split.length == 6 && FRAME_HEAD.equals(split[0]) && FRAME_TAIL.equals(split[5])) {
            collData.setAreaId(Integer.parseInt(split[1]));
            collData.setLight(Float.parseFloat(split[2]));
            collData.setTemp(Float.parseFloat(split[3]));
            collData.setHum(Float.parseFloat(split[4]));
            collData.setIp(clientIp);

            serverHandler.collDataService.insertData(collData);
        } else if (split.length == 5 && FRAME_HEAD.equals(split[0]) && FRAME_TAIL.equals(split[4])) {
            collData.setAreaId(Integer.parseInt(split[1]));
            collData.setSoil(Float.parseFloat(split[2]));
            collData.setSound(Float.parseFloat(split[3]));
            collData.setIp(clientIp);

            serverHandler.collDataService.insertData(collData);
        } else if (split.length == 8 && FRAME_HEAD.equals(split[0]) && FRAME_TAIL.equals(split[7])) {
            collData.setAreaId(Integer.parseInt(split[1]));
            collData.setLight(Float.parseFloat(split[2]));
            collData.setTemp(Float.parseFloat(split[3]));
            collData.setHum(Float.parseFloat(split[4]));
            collData.setSoil(Float.parseFloat(split[5]));
            collData.setSound(Float.parseFloat(split[6]));
            collData.setIp(clientIp);

            serverHandler.collDataService.insertData(collData);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("客户端【" + ctx.channel() + "】断开连接！");
    }


}
