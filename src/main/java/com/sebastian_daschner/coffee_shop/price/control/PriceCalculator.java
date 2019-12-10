package com.sebastian_daschner.coffee_shop.price.control;

import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeOrder;
import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeType;
import org.eclipse.microprofile.config.ConfigProvider;

public class PriceCalculator {

    public double calculatePrice(CoffeeOrder order) {
        return getConfiguredPrice(order.getType());
    }

    private double getConfiguredPrice(CoffeeType type) {
        String key = "coffee.prices." + type.name().toLowerCase();
        return ConfigProvider.getConfig().getValue(key, double.class);
    }

}
