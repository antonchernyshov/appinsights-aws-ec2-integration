# appinsights-aws-ec2-integration
Using Azure AppInsights to monitor Spring Boot app deployed to AWS EC2(beanstalk, etc.)?

You're not alone!

This project helps to add AWS EC2 instance id to each telemetry record, that is sent to AppInsights.


## How to use:

You need to add new dependency to your project.

Here's how to do it:

### Gradle
 
```
dependencies {

    implementation 'com.antonchernyshov.integrations.appinsights.aws.ec2:spring-boot-configuration:0.1'    
    
}
```

### Maven

``` xml
<dependency>
  <groupId>com.antonchernyshov.integrations.appinsights.aws.ec2</groupId>
  <artifactId>spring-boot-configuration</artifactId>
  <version>0.1</version>
</dependency>
```

This will add needed configuration, which Spring Boot will use without additional actions.

### Copy and paste :)

If you can not add new dependency to the project - check out the source code and copy 2 classes to your project: 

 *AppInsightsAwsAutoConfiguration* and *Ec2AwareTelemetryInitializer*

## Customization

You can customize the name of the property to be used for EC2 Instance ID:

``` properties
#Customizing EC2 instance id property name
com.antonchernyshov.integrations.appinsights.aws.ec2.property-name=EC2-INSTANCE-ID
```

## Sample project

I created a sample Spring Boot project, mainly for testing purposes. There is a telemetry generator, that generates all kinds 
of telemetry and sends it to Azure AppInsights.

You can use it for a reference.

Important! Update *application.properties* with your own instrumentation key.

You can find more details on how to set it up here:
 * https://docs.microsoft.com/en-us/azure/azure-monitor/app/java-get-started 
 * https://docs.microsoft.com/en-us/azure/developer/java/spring-framework/configure-spring-boot-java-applicationinsights
