package com.antonchernyshov.integrations.appinsights.aws.ec2.sample.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Anton Chernyshov
 */
@SpringBootTest
class ApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

	@Test
	void testEc2InitializerPresent() {
        try {
            applicationContext.getBean("ec2TelemetryInitializer");

        } catch (NoSuchBeanDefinitionException e) {
            fail("EC2 telemetry initializer is missing in app context");
        }

	}

}
