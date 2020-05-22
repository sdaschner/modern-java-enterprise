package com.sebastian_daschner.coffee_shop.orders.boundary;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeShopIT {

    private final CoffeeShopSystem coffeeShopSystem = new CoffeeShopSystem();

    @Test
    void testIsSystemRunning() {
        assertThat(coffeeShopSystem.isSystemUp()).isTrue();
    }

    @Test
    void testVersion() {
        assertThat(coffeeShopSystem.getAppVersion()).isEqualTo("1.2.3");
    }



}
