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


        // index

        get("/baskets/orders", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            User loggedInUser = LoginController.getLoggedInUserName(req, res);
            Basket basket = loggedInUser.getBasket();
            List<Order> orders = basket.getOrders();
            model.put("template", "templates/baskets/index.vtl");
            model.put("basket", basket);
            model.put("orders", orders);
            model.put("user", loggedInUser);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



       // show all baskets by id

//        get("/baskets/:id")





        //post

//
//        post ("/baskets/orders", (req, res) -> {
//            int user = Integer.parseInt(req.queryParams("user"));
//            int Product;
//            Product product = DBHelper.find(Product.class, productId);
//            int quantity = Integer.parseInt(req.queryParams("quantity"));
//
//
//            Basket basket = new Product();
//
//
//            DBHelper.save(basket);
//            res.redirect("/baskets");
//            return null;
//
//        },new VelocityTemplateEngine());
//




        // destroy

//
//        post ("/baskets/:id/delete", (req, res) -> {
//            int id = Integer.parseInt(req.params(":id"));
//            Product productToDelete = DBHelper.find(Product.class, id);
//            DBHelper.delete(productToDelete);
//            res.redirect("/baskets");
//            return null;
//        }, new VelocityTemplateEngine());
//
//
    }
}
