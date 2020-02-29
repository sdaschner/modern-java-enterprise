package com.sebastian_daschner.coffee_shop.orders.boundary;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.concurrent.TimeUnit;

class CoffeeShopSystem {

    private final WebTarget healthTarget;

    public CoffeeShopSystem() {
        Client client = ClientBuilder.newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        healthTarget = client.target(buildHealthUri());
    }

    private URI buildHealthUri() {
        String host = System.getProperty("coffee-shop.test.host", "localhost");
        String port = System.getProperty("coffee-shop.test.port", "8080");
        return UriBuilder.fromUri("http://{host}:{port}/health/").build(host, port);
    }

    public boolean isSystemUp() {
        String status = healthTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .get(JsonObject.class)
                .getString("status");
        return "UP".equalsIgnoreCase(status);
    }

    public String getAppVersion() {
        return healthTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .get(JsonObject.class)
                .getJsonArray("checks")
                .getValuesAs(JsonObject.class)
                .stream()
                .filter(o -> o.getString("name").equalsIgnoreCase("coffee-shop"))
                .map(o -> o.getJsonObject("data").getString("version"))
                .findAny().orElse(null);
    }

}
