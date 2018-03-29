package controllers;

import db.DBHelper;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class UsersController {

    public UsersController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {


        post("/users", (req, res) -> {
            String name = req.queryParams("name");
            String username = req.queryParams("username");

            DBHelper.createUser(name, username);

            req.session().attribute("name", name);
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());


    }

}
