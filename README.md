# appinsights-aws-ec2-integration
Using Azure AppInsights to monitor Spring Boot app deployed to AWS EC2(beanstalk, etc.)?

You're not alone!

This project helps to add AWS EC2 instance id to each telemetry record, that is sent to AppInsights.


##How to use:

###Gradle 
```
dependencies {

    implementation 'com.antonchernyshov.integrations.appinsights.aws.ec2:spring-boot-configuration:0.0.1'    
    
}
```
