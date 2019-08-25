package com.sebastian_daschner.coffee_shop.orders.boundary;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class CoffeeShopIT {

    private CoffeeShopSystem coffeeShop = new CoffeeShopSystem();

    @Test
    void testSystemIsUp() {
        assertThat(coffeeShop.isSystemUp()).isTrue();
    }

    @Test
    void testApplicationVersion() {
        assertThat(coffeeShop.getAppVersion()).isEqualTo("1.2.3");
    }

}