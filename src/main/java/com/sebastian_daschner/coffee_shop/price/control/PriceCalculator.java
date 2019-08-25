package com.sebastian_daschner.coffee_shop.price.control;

import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeOrder;
import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeType;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import java.math.BigInteger;

public class PriceCalculator {

    @Inject
    @ConfigProperty(name = "coffee.permanent_discount", defaultValue = "0.0")
    double permanentDiscount;

    public BigInteger calculatePrice(CoffeeOrder order) {
        CoffeeType type = order.getType();

        Integer price = getConfiguredPrice(type);

        return calculateDiscount(price);
    }

    private Integer getConfiguredPrice(CoffeeType type) {
        return ConfigProvider.getConfig().getValue("coffee.prices." + type.name().toLowerCase(), int.class);
    }

    private BigInteger calculateDiscount(Integer price) {
        BigInteger discount = BigInteger.valueOf(Math.round(price * permanentDiscount));
        return BigInteger.valueOf(price).subtract(discount);
    }

}
