package net.iot228;

import net.iot228.netty.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbWebApplication.class, args);
        new NettyServer(5000).start();
    }

}
