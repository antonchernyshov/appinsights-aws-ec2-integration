package com.antonchernyshov.integrations.appinsights.aws.ec2.sample.app;

import com.amazonaws.util.EC2MetadataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

	    log.info("Starting EC2 instance aware application");
		SpringApplication.run(Application.class, args);
		log.info("Application is started. Here's the instance id: {}", EC2MetadataUtils.getInstanceId());
	}

}
