package com.iot45;

import com.iot45.netty.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.iot45")
public class BookShowWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookShowWebApplication.class, args);
        new NettyServer(5000).start();
    }

}
