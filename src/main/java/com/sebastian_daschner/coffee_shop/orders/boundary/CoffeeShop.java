package com.sebastian_daschner.coffee_shop.orders.boundary;

import com.sebastian_daschner.coffee_shop.orders.control.Orders;
import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeOrder;
import com.sebastian_daschner.coffee_shop.price.control.PriceCalculator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CoffeeShop {

    @Inject
    Orders orders;

    @Inject
    PriceCalculator priceCalculator;

    public List<CoffeeOrder> getOrders() {
        return orders.retrieveAll();
    }

    public CoffeeOrder getOrder(UUID id) {
        return orders.retrieve(id);
    }

    public CoffeeOrder orderCoffee(CoffeeOrder order) {
        order.setId(UUID.randomUUID());
        order.setPrice(priceCalculator.calculatePrice(order));

        orders.store(order.getId(), order);

        return order;
    }

}
