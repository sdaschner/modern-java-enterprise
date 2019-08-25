package com.sebastian_daschner.coffee_shop.health.boundary;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Readiness
public class Health implements HealthCheck {

    @Inject
    @ConfigProperty(name = "version", defaultValue = "N/A")
    String appVersion;

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("coffee-shop")
                .up()
                .withData("version", appVersion)
                .build();
    }

}
