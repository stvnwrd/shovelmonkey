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
            model.put("template", "templates/products/index.vtl");
            model.put("baskets", baskets);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        // new

        get("/baskets/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Order> orders = DBHelper.getAll(SubCategory.class);
            model.put("totalTradeCost", totalTradeCost);
            model.put("totalVatCost", totalVatCost);
            model.put("totalCost", totalCost);
            model.put("totalItems", totalItems);
            model.put("template", "templates/baskets/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        // destroy


        post ("/baskets/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Product productToDelete = DBHelper.find(Product.class, id);
            DBHelper.delete(productToDelete);
            res.redirect("/baskets");
            return null;
        }, new VelocityTemplateEngine());


    }
}