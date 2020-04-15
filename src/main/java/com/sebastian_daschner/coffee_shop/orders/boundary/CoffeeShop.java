package com.sebastian_daschner.coffee_shop.orders.boundary;

import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeOrder;
import com.sebastian_daschner.coffee_shop.price.control.PriceCalculator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@ApplicationScoped
@Transactional
public class CoffeeShop {

    @Inject
    PriceCalculator priceCalculator;

    public Collection<CoffeeOrder> getOrders() {
        return CoffeeOrder.listAll();
    }

    public CoffeeOrder getOrder(UUID id) {
        return CoffeeOrder.findById(id);
    }

    public CoffeeOrder orderCoffee(CoffeeOrder order) {
        order.price = priceCalculator.calculatePrice(order);

        CoffeeOrder.persist(order);
        return order;
    }

}
