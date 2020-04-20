package com.sebastian_daschner.coffee_shop.orders.boundary;

import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeOrder;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.ResourcePath;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class OrdersController {

    @ResourcePath("index.html")
    Template indexTemplate;

    @Inject
    CoffeeShop coffeeShop;

    @GET
    public TemplateInstance index() {
        List<CoffeeOrder> orders = coffeeShop.getOrders();
        return indexTemplate.data("orders", orders);
    }


}
