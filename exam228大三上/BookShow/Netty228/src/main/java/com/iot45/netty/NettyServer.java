package com.iot45.netty;/*
 * @Systemname: BookShow
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  15:38 2022/1/4
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;




public class NettyServer extends Thread {

    private int port=5000;

    protected static Channel channel;


    public NettyServer(int port) {
        this.port = port;
    }

    @Override
    public void start() {

        /* new 一个主线程组*/
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        /* new 一个工作线程组*/
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            //创建和配置ServerBootstrap
            ServerBootstrap serverBootstrap = new ServerBootstrap()
                    .group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 512)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //创建ChannelInitializer
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            socketChannel.pipeline()
                                    //解码
                                    .addLast("decoder", new StringDecoder(CharsetUtil.UTF_8))
                                    //编码
                                    .addLast("encoder", new StringEncoder(CharsetUtil.UTF_8))
                                    // 用于心跳检测
                                    .addLast(new NettyServerHandler());
                        }
                    });
            //  log.info("server listened at port:{}", port);
            System.err.println("server listened at port:{}"+ port);
            //启动服务
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            //  log.info("server started...");

            // 异步方式关闭
            channelFuture.channel().closeFuture().sync();
            //  log.info("server stopped...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bossGroup.shutdownGracefully().sync();
                workGroup.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean sendMsg(String msg) {
        if (channel == null) {
            return false;
        }
        channel.writeAndFlush("#" + msg + "$");
        return true;
    }

}
