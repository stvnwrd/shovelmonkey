package controllers;

import db.DBHelper;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BasketsController {
    public BasketsController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {


        // index for users basket

        get("/baskets/orders", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            User loggedInUser = LoginController.getLoggedInUser(req, res);
            Basket basket = loggedInUser.getBasket();
            List<Order> orders = basket.getOrders();
            model.put("template", "templates/baskets/index.vtl");
            model.put("basket", basket);
            model.put("orders", orders);
            model.put("user", loggedInUser);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



        // add to basket

        post("/baskets/orders", (req, res) -> {
            User loggedInUser = LoginController.getLoggedInUserName(req, res);
            int productId = Integer.parseInt(req.queryParams("product"));
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            Product product = DBHelper.find(Product.class, productId);

            DBHelper.createOrder(loggedInUser, product, quantity);

            res.redirect("/baskets/orders");
            return null;
        }, new VelocityTemplateEngine());


        // Buy

        post ("/baskets/orders/clear", (req, res) -> {
            User currentUser = LoginController.getLoggedInUser(req, res);

            DBHelper.buyItems(currentUser);

            res.redirect("/baskets/orders");
            return null;

        }, new VelocityTemplateEngine());

    }
}
