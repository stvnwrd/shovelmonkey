package controllers;


import db.DBHelper;
import models.Category;
import models.Product;
import models.SubCategory;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ProductsController {
    public ProductsController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {


        // index

        get("/products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Product> products = DBHelper.getAll(Product.class);
            model.put("template", "templates/products/index.vtl");
            model.put("products", products);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        // new

        get("/products/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Category> categories = DBHelper.getAll(Category.class);
            List<SubCategory> subCategories = DBHelper.getAll(SubCategory.class);
            model.put("categories", categories);
            model.put("subCategories", subCategories);
            model.put("template", "templates/products/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        // create

        post ("/products", (req, res) -> {
//            int categoryId = Integer.parseInt(req.queryParams("category"));
//            Category category = DBHelper.find(Category.class, categoryId);
            int subCategoryId = Integer.parseInt(req.queryParams("subCategory"));
            SubCategory subCategory = DBHelper.find(SubCategory.class, subCategoryId);
            String name = req.queryParams("name");
            String blurb = req.queryParams("blurb");
            int price = Integer.parseInt(req.queryParams("price"));
            Product product = new Product(name, price, blurb,  subCategory, shop);
            DBHelper.save(product);
            res.redirect("/products");
            return null;

        },new VelocityTemplateEngine());





        // show

        get("/products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Product product = DBHelper.find(Product.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("product", product);
            model.put("template", "templates/products/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());





        // edit

        get("/products/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Product product = DBHelper.find(Product.class, intId);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<SubCategory> subCategories = DBHelper.getAll(SubCategory.class);
            Map<String, Object> model = new HashMap<>();
            model.put("categories", categories);
            model.put("subCategories", subCategories);
            model.put("template", "templates/products/edit.vtl");
            model.put("product", product);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



        // update

        post ("/products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Product product = DBHelper.find(Product.class, intId);
            int subCategoryId = Integer.parseInt(req.queryParams("subCategory"));
            SubCategory subCategory = DBHelper.find(SubCategory.class, subCategoryId);
            String name = req.queryParams("name");
            int price = Integer.parseInt(req.queryParams("price"));
            String blurb = req.queryParams("blurb");

            product.setName(name);
            product.setPrice(price);
            product.setBlurb(blurb);
            product.setSubCategory(subCategory);
            // set shop
            DBHelper.save(product);
            res.redirect("/products");
            return null;

        }, new VelocityTemplateEngine());






        // destroy


        post ("/products/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req, res) -> {
                Product productToDelete = DBHelper.find(id, Product.class);
                DBHelper.delete(productToDelete);
                res.redirect("/products");
                return null;
            }
        }, new VelocityTemplateEngine());





    }
}
