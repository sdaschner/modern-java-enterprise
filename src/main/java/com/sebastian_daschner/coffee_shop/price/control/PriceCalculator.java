package com.sebastian_daschner.coffee_shop.price.control;

import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeOrder;
import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeType;
import org.eclipse.microprofile.config.ConfigProvider;

public class PriceCalculator {

    public int calculatePrice(CoffeeOrder order) {
        return getPriceForType(order.getType());
    }

    private int getPriceForType(CoffeeType type) {
        String key = "coffee.prices." + type.name().toLowerCase();
        return ConfigProvider.getConfig()
                .getOptionalValue(key, int.class)
                .orElse(0);
    }


}
