package controllers;


import db.DBHelper;
import models.Category;
import models.Product;
import models.Shop;
import models.SubCategory;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.ArrayList;
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


        // index for cat

        get("/products/category/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category category = DBHelper.find(Category.class, intId);
            List<SubCategory> subCategories = DBHelper.findSubCatsByCategory(category);
            List<Product> products = new ArrayList<>();
            for (SubCategory subCategory : subCategories) {
                List<Product> productsBySubCategory = DBHelper.findProductsBySubCategory(subCategory);
                for (Product product : productsBySubCategory) {
                    products.add(product);
                }
            }
            Map<String, Object> model = new HashMap<>();
            model.put("products", products);
            model.put("template", "templates/products/showbycat.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        // index for subcat

        get("/products/subCategory/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            SubCategory subCategory = DBHelper.find(SubCategory.class, intId);
            List<Product> products = DBHelper.findProductsBySubCategory(subCategory);
            Map<String, Object> model = new HashMap<>();
            model.put("products", products);
            model.put("template", "templates/products/showbysubcat.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        // new

        get("/products/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Shop> shops = DBHelper.getAll(Category.class);
            List<SubCategory> subCategories = DBHelper.getAll(SubCategory.class);
            model.put("shops", shops);
            model.put("subCategories", subCategories);
            model.put("template", "templates/products/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        // create

        post ("/products", (req, res) -> {
            int shopId = Integer.parseInt(req.queryParams("shop"));
           Shop shop = DBHelper.find(Shop.class, shopId);
            int subCategoryId = Integer.parseInt(req.queryParams("subCategory"));
            SubCategory subCategory = DBHelper.find(SubCategory.class, subCategoryId);

            String name = req.queryParams("name");
            String blurb = req.queryParams("blurb");
            int price = Integer.parseInt(req.queryParams("price"));


            Product product = new Product(name, price, blurb, subCategory, shop);

            // need to look at shop here

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
            List<Shop> shops = DBHelper.getAll(Shop.class);
            List<SubCategory> subCategories = DBHelper.getAll(SubCategory.class);
            Map<String, Object> model = new HashMap<>();
            model.put("shops", shops);
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
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);
            String name = req.queryParams("name");
            int price = Integer.parseInt(req.queryParams("price"));
            String blurb = req.queryParams("blurb");

            product.setName(name);
            product.setPrice(price);
            product.setBlurb(blurb);
            product.setSubCategory(subCategory);
            product.setShop(shop);
            DBHelper.save(product);
            res.redirect("/products");
            return null;

        }, new VelocityTemplateEngine());




        // destroy


        post ("/products/:id/delete", (req, res) -> {
                int id = Integer.parseInt(req.params(":id"));
                Product productToDelete = DBHelper.find(Product.class, id);
                DBHelper.delete(productToDelete);
                res.redirect("/products");
                return null;
        }, new VelocityTemplateEngine());


    }
}
