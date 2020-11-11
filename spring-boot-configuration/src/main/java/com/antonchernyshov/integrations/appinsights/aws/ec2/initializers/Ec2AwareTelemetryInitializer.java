package com.antonchernyshov.integrations.appinsights.aws.ec2.initializers;

import com.amazonaws.util.EC2MetadataUtils;
import com.microsoft.applicationinsights.extensibility.TelemetryInitializer;
import com.microsoft.applicationinsights.telemetry.Telemetry;

/**
 * Adds EC2 Instance ID to telemetry context
 *
 * @author Anton Chernyshov
 */
public class Ec2AwareTelemetryInitializer implements TelemetryInitializer {

    private String propertyName = "EC2 Instance Id";

    /**
     * Creates new instance.
     *
     * @param propertyName name of the property to use. If not defined - {@link #propertyName default property name} will be used.
     */
    public Ec2AwareTelemetryInitializer(String propertyName) {
        if (propertyName != null && !propertyName.isEmpty()) {
            this.propertyName = propertyName;
        }
    }

    @Override
    public void initialize(Telemetry telemetry) {
        String instanceId = getInstanceId();
        if (instanceId == null || instanceId.isEmpty()) {
            instanceId = "Not defined";
        }

        telemetry.getProperties().put(propertyName, instanceId);
    }

    private String getInstanceId() {
        try {
            return EC2MetadataUtils.getInstanceId();
        } catch (Exception e) {
            return null;
        }
    }
}
