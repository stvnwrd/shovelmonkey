import db.DBHelper;
import models.Category;
import models.Product;
import models.Shop;
import models.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class runner {

    public static void main(String[] args) {



        Category category1 = new Category("Excavation");
        DBHelper.save(category1);
        Category category2 = new Category("Recording");
        DBHelper.save(category2);


        SubCategory subCategory1 = new SubCategory("Trowels and Small Tools", category1);
        DBHelper.save(subCategory1);
        SubCategory subCategory2 = new SubCategory("Spades, Shovels and Mattocks", category1);
        DBHelper.save(subCategory2);
        SubCategory subCategory3 = new SubCategory("Drafting Film, Notebooks, and Record Sheets", category2);
        DBHelper.save(subCategory3);
        SubCategory subCategory4 = new SubCategory("Gauges and Callipers", category2);
        DBHelper.save(subCategory4);


        category1.addSubCategory(subCategory1);
        category1.addSubCategory(subCategory2);
        category2.addSubCategory(subCategory3);
        category2.addSubCategory(subCategory4);

        List<Product> stock = new ArrayList<>();
        Shop shop = new Shop(stock);
        DBHelper.save(shop);

        Product product1 = new Product("Trowel", 1599, "The finest archaeology trowel.", subCategory1, shop);
        DBHelper.save(product1);
        Product product2 = new Product("Shovel", 1599, "For the best in shovelling.", subCategory2, shop);
        DBHelper.save(product2);
        Product product3 = new Product("Spade", 1599, "This spade's great.", subCategory2, shop);
        DBHelper.save(product3);
        Product product4 = new Product("Mattock", 1599, "Mattock like a champ!", subCategory2, shop);
        DBHelper.save(product4);
        Product product5 = new Product("Permatrace", 1599, "You can certainly trace permanently on this.", subCategory3, shop);
        DBHelper.save(product5);
        Product product6 = new Product("Line Level", 1599, "For level string, everytime.", subCategory4, shop);
        DBHelper.save(product6);

        subCategory1.addProduct(product1);
        subCategory2.addProduct(product2);
        subCategory2.addProduct(product3);
        subCategory2.addProduct(product4);
        subCategory3.addProduct(product5);
        subCategory4.addProduct(product6);


        shop.addToStock(product1, 3);
        product1.adjustStockQuantity(3);
        DBHelper.save(product1);

        List<Product> allProducts = DBHelper.getAll(Product.class);
        List<Category> allCategories = DBHelper.getAll(Category.class);
        List<SubCategory> allSubCategories = DBHelper.getAll(SubCategory.class);

        Product foundProductById = DBHelper.find(Product.class, product1.getId());
        Category foundCategoryById = DBHelper.find(Category.class, category1.getId());
        SubCategory foundSubCategoryById = DBHelper.find(SubCategory.class, subCategory1.getId());

        List<Product> productsBySubCat = DBHelper.findProductsBySubCategory(subCategory2);
        List<SubCategory> subCatsByCat = DBHelper.findSubCatsByCategory(category1);


        product1.setName("Hiya");
        DBHelper.save(product1);

    }
}
