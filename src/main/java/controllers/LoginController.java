package controllers;

import db.DBHelper;
import models.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class LoginController {
    public LoginController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get ("/login", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "templates/login.vtl");
        }, new VelocityTemplateEngine());

        post("/login", (req, res) -> {
            String name = req.queryParams("name");
            req.session().attribute("name", name);
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());

        get ("/logout", (req, res) -> {
            req.session().removeAttribute("name");
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());
    }

    public static User getLoggedInUserName(Request req, Response res) {

        List<User> allUsers = DBHelper.getAll(User.class);
        List<String> allNames = new ArrayList<>();
        for (User item : allUsers) {
            allNames.add(item.getName());
        }


        String name = req.session().attribute("name");


        if (name == null || name.isEmpty() || !(allNames.contains(name))) {
            res.redirect("/login");
        }else
            for (User user : allUsers) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
        return null;
    }


    public static User getLoggedInUser(Request req, Response res) {
        String name = req.session().attribute("name");
        List<User> allUsers = DBHelper.getAll(User.class);
            for (User user : allUsers) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
        return null;
    }
}
