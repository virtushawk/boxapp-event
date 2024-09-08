package com.virtushawk.boxappevent.service.message;

import com.virtushawk.boxappevent.conf.RabbitMQConfig;
import com.virtushawk.boxappevent.service.RegistrationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Listener to message queue with circuit breaker
 */
@Service
@CircuitBreaker(name = "eventCircuitBreaker", fallbackMethod = "fallback")
public class RegistrationListener {

    private final RegistrationService registrationService;

    public RegistrationListener(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    /**
     * Unregister user from all events
     *
     * @param username name of the user
     */
    @RabbitListener(queues = {RabbitMQConfig.UNREGISTER_QUEUE_NAME})
    public void unregister(String username) {
        registrationService.deleteAllAssignedToUsername(username);
    }

    /**
     * Fallback method for circuit breaker
     */
    public String fallback(Throwable throwable) {
        return "Fallback";
    }
}
