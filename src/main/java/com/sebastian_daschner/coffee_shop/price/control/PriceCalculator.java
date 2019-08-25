package com.sebastian_daschner.coffee_shop.price.control;

import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeOrder;
import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeType;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;

public class PriceCalculator {

    @Inject
    @ConfigProperty(name = "coffee.permanent_discount", defaultValue = "0.0")
    double permanentDiscount;

    public int calculatePrice(CoffeeOrder order) {
        int price = getConfiguredPrice(order.getType());

        return calculateDiscount(price);
    }

    private int getConfiguredPrice(CoffeeType type) {
        return ConfigProvider.getConfig().getValue("coffee.prices." + type.name().toLowerCase(), int.class);
    }

    private int calculateDiscount(int price) {
        int discount = (int) Math.round(permanentDiscount * price);
        return price - discount;
    }
}
