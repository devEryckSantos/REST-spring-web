package br.com.dio.REST_spring.infra.security.check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class HealthCheck implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            if(address.isReachable(10000))
                return Health.up().build();
        } catch (Exception e) {
            return Health.down().withDetail("Motivo", e.getMessage()).build();
        }
        return Health.down().withDetail("Motivo", "Motivo desconhecido.").build();
    }
}
