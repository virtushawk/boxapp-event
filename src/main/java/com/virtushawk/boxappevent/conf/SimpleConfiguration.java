package com.virtushawk.boxappevent.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * Simple configuration class to demonstrate configuration fetch from configuration service and dynamic reload
 */
@Configuration
@RefreshScope
public class SimpleConfiguration {

    @Value("${tracer.property}")
    private String nameValue;

    @Value("${app.event.circuitBreaker.name}")
    private String circuitBreakerName;

    public String getNameValue() {
        return nameValue;
    }

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public String getCircuitBreakerName() {
        return circuitBreakerName;
    }

    public void setCircuitBreakerName(String circuitBreakerName) {
        this.circuitBreakerName = circuitBreakerName;
    }
}
