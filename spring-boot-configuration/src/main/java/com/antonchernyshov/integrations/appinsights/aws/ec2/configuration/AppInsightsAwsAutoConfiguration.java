package com.antonchernyshov.integrations.appinsights.aws.ec2.configuration;

import com.antonchernyshov.integrations.appinsights.aws.ec2.initializers.Ec2AwareTelemetryInitializer;
import com.microsoft.applicationinsights.autoconfigure.conditionals.InstrumentationKeyCondition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Registers AWS EC2 Instance aware telemetry initializer, which adds EC2 Instance Id to each telemetry entry
 */
@Configuration
@Conditional(InstrumentationKeyCondition.class)
@ConfigurationProperties(prefix = "com.antonchernyshov.azure.appinsights.ec2")
public class AppInsightsAwsAutoConfiguration {

    String propertyName;

    @Bean
    public Ec2AwareTelemetryInitializer ec2TelemetryInitializer() {
        return new Ec2AwareTelemetryInitializer(propertyName);
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
