package com.antonchernyshov.integrations.appinsights.aws.ec2.sample.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Sample app that allows to generate telemetry and make sure everything works
 *
 * @author Anton Chernyshov
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
