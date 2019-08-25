package com.sebastian_daschner.coffee_shop.orders.entity;

import java.util.stream.Stream;

public enum CoffeeType {

    ESPRESSO,
    LATTE,
    POUR_OVER;

    public static CoffeeType fromString(String string) {
        return Stream.of(CoffeeType.values())
                .filter(t -> t.name().equalsIgnoreCase(string))
                .findAny().orElse(null);
    }

}
