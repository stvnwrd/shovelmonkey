package controllers;

import db.Seeds;
import models.Basket;
import models.LogIn;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class  MainController {

    public static void main(String[] args) {


        Seeds.seedData();

        staticFileLocation("/public");

        ProductsController productsController = new ProductsController();
        BasketsController basketsController = new BasketsController();
        LoginController loginController = new LoginController();
        UsersController usersController = new UsersController();


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            User loggedInUser = LoginController.getLoggedInUser(req, res);
            model.put("user", loggedInUser);
            model.put("template","templates/main.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
