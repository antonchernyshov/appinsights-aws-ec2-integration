package com.antonchernyshov.integrations.appinsights.aws.ec2.sample.app;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.web.dependencies.apachecommons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

/**
 * Telemetry generator. Generates telemetry and sends it to Azure AppInsights
 *
 * @author Anton Chernyshov
 */
@Service
public class TelemetryGenerator {

    @Autowired
    TelemetryClient telemetryClient;

    @Scheduled(fixedRate = 1000, initialDelay = 1000)
    public void generateTelemetry() {
        telemetryClient.trackTrace("Trace message: " + UUID.randomUUID().toString());
        telemetryClient.trackEvent("Event", Collections.singletonMap("uuid", UUID.randomUUID().toString()), Collections.singletonMap("value", RandomUtils.nextDouble()));
        telemetryClient.trackException(new RuntimeException("Its time to run!"));
        telemetryClient.trackMetric("metric", RandomUtils.nextDouble());
    }
}
