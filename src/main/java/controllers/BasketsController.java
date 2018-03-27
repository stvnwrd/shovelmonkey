package controllers;

import db.DBHelper;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

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

        get("/baskets", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Basket> baskets = DBHelper.getAll(Basket.class);
            model.put("template", "templates/baskets/index.vtl");
            model.put("baskets", baskets);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        // show

        get("/baskets/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Basket basket = DBHelper.find(Basket.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("basket", basket);
            model.put("template", "templates/baskets/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//   PLACEHOLDER ROUTES PROBABLY NOT NEEDED
//
//        // edit
//
//        get("/baskets/:id/edit", (req, res) -> {
//            String strId = req.params(":id");
//            Integer intId = Integer.parseInt(strId);
//            Basket basket = DBHelper.find(Basket.class, intId);
//            List<Order> orders = DBHelper.getAll(Order.class);
//
//            Map<String, Object> model = new HashMap<>();
//
//            model.put("orders", orders);
//            model.put("template", "templates/baskets/edit.vtl");
//            model.put("basket", basket);
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, new VelocityTemplateEngine());
//
//
//
//        // update
//
//        post ("/baskets/:id", (req, res) -> {
//            String strId = req.params(":id");
//            Integer intId = Integer.parseInt(strId);
//            Basket basket = DBHelper.find(Basket.class, intId);
//            String user = req.queryParams("user");
//            int orderId = Integer.parseInt(req.queryParams("order"));
//            Order orders = DBHelper.find(Order.class, orderId);
//            int totalTradeCost = Integer.parseInt(req.queryParams("totalTradeCost"));
//            int totalVatCost = Integer.parseInt(req.queryParams("totalVatCost"));
//            int totalCost = Integer.parseInt(req.queryParams("totalCost"));
//            int totalItems = Integer.parseInt(req.queryParams("totalItems"));
//
//            basket.setUser(user);
//            basket.setOrders(orders);
//            basket.setTotalTradeCost(totalTradeCost);
//            basket.setTotalVatCost(totalVatCost);
//            basket.setTotalCost(totalCost);
//            basket.setTotalItems(totalItems);
//
//            DBHelper.save(basket);
//            res.redirect("/baskets");
//            return null;
//
//        }, new VelocityTemplateEngine());
//
//
//
//



//         destroy

        post ("/baskets/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Product productToDelete = DBHelper.find(Product.class, id);
            DBHelper.delete(productToDelete);
            res.redirect("/baskets");
            return null;
        }, new VelocityTemplateEngine());


    }
}
