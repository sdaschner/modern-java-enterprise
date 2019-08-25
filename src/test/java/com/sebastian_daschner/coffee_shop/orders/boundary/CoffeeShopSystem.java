package com.sebastian_daschner.coffee_shop.orders.boundary;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

class CoffeeShopSystem {

    private final Client client;
    private final WebTarget healthTarget;

    public CoffeeShopSystem() {
        client = ClientBuilder.newClient();
        healthTarget = client.target("http://localhost:9080/health");
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
