package com.iot310.datacoll;

import com.iot310.datacoll.netty.TcpServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author TanXY
 */
@SpringBootApplication
public class Rs485AndCanDataCollApplication {

    public static void main(String[] args) {
        SpringApplication.run(Rs485AndCanDataCollApplication.class, args);

        new TcpServer().start();
    }

}
