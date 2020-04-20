package com.ait.config.cloudConfigServer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringAppliciation {
    public static void run(Class<CloudConfigServerApplication> cloudConfigServerApplicationClass, String[] args) {
    }
}
