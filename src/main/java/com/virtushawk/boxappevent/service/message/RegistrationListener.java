package com.virtushawk.boxappevent.service.message;

import com.virtushawk.boxappevent.conf.RabbitMQConfig;
import com.virtushawk.boxappevent.service.RegistrationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@CircuitBreaker(name = "eventCircuitBreaker", fallbackMethod = "fallback")
public class RegistrationListener {

    private final RegistrationService registrationService;

    public RegistrationListener(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RabbitListener(queues = {RabbitMQConfig.UNREGISTER_QUEUE_NAME})
    public void unregister(String username) {
        registrationService.deleteAllAssignedToUsername(username);
    }

    public String fallback(Throwable throwable) {
        return "Fallback";
    }
}
