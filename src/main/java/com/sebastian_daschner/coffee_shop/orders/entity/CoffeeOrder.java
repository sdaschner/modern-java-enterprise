package com.sebastian_daschner.coffee_shop.orders.entity;

import com.sebastian_daschner.coffee_shop.orders.CoffeeTypeDeserializer;

import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CoffeeOrder {

    @JsonbTransient
    private UUID id;

    @NotNull
    @JsonbTypeAdapter(CoffeeTypeDeserializer.class)
    private CoffeeType type;

    private int price;

    private OrderStatus status = OrderStatus.PREPARING;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CoffeeType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(CoffeeType type) {
        this.type = type;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
