package db;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class Seeds {


    public static void seedData() {

        DBHelper.deleteAll(Product.class);
        DBHelper.deleteAll(SubCategory.class);
        DBHelper.deleteAll(Category.class);
        DBHelper.deleteAll(Shop.class);




        Category category1 = new Category("Excavation");
        DBHelper.save(category1);
        Category category2 = new Category("Drawing & Recording");
        DBHelper.save(category2);
        Category category3 = new Category("Finds & Storage");
        DBHelper.save(category3);
        Category category4 = new Category("Survey & Measure");
        DBHelper.save(category4);



        SubCategory subCategory1 = new SubCategory("Trowels & Small Tools", category1);
        DBHelper.save(subCategory1);
        SubCategory subCategory2 = new SubCategory("Spades, Shovels, & Mattocks", category1);
        DBHelper.save(subCategory2);
        SubCategory subCategory3 = new SubCategory("Brushes & Buckets", category1);
        DBHelper.save(subCategory3);
        SubCategory subCategory4 = new SubCategory("Sieves & Tarpaulins", category1);
        DBHelper.save(subCategory4);

        SubCategory subCategory5 = new SubCategory("Drafting Film, Notebooks, & Record Sheets", category2);
        DBHelper.save(subCategory5);
        SubCategory subCategory6 = new SubCategory("Gauges & Callipers", category2);
        DBHelper.save(subCategory6);
        SubCategory subCategory7 = new SubCategory("Pens & Pencils", category2);
        DBHelper.save(subCategory7);
        SubCategory subCategory8 = new SubCategory("Photography", category2);
        DBHelper.save(subCategory8);

        SubCategory subCategory9 = new SubCategory("Bags & Boxes", category3);
        DBHelper.save(subCategory9);
        SubCategory subCategory10 = new SubCategory("Files, Folders, & Clipboards", category3);
        DBHelper.save(subCategory10);
        SubCategory subCategory11 = new SubCategory("Labels & Accessories", category3);
        DBHelper.save(subCategory11);
        SubCategory subCategory12 = new SubCategory("Picks, Magnifiers, & Tweezers", category3);
        DBHelper.save(subCategory12);

        SubCategory subCategory13 = new SubCategory("Lines, Levels, & Compasses", category4);
        DBHelper.save(subCategory13);
        SubCategory subCategory14 = new SubCategory("Pegs, Pins, & Nails", category4);
        DBHelper.save(subCategory14);
        SubCategory subCategory15 = new SubCategory("Tapes & Rulers", category4);
        DBHelper.save(subCategory15);


        category1.addSubCategory(subCategory1);
        category1.addSubCategory(subCategory2);
        category1.addSubCategory(subCategory3);
        category1.addSubCategory(subCategory4);
        category2.addSubCategory(subCategory5);
        category2.addSubCategory(subCategory6);
        category2.addSubCategory(subCategory7);
        category2.addSubCategory(subCategory8);
        category3.addSubCategory(subCategory9);
        category3.addSubCategory(subCategory10);
        category3.addSubCategory(subCategory11);
        category3.addSubCategory(subCategory12);
        category4.addSubCategory(subCategory13);
        category4.addSubCategory(subCategory14);
        category4.addSubCategory(subCategory15);


        List<Product> stock = new ArrayList<>();
        Shop shop = new Shop(stock);
        DBHelper.save(shop);


        Product product1 = new Product("WHS Trowel 4 inch", 895, "This is the 'Original' thicker blade 4\" (10 cm) archaeologist's trowel. It is designed to work in any conditions and any type of excavation. The trowel is hand crafted from the carbon steel with a thick solid forged blade for ultimate strength.", subCategory1, "/images/trowel.png", shop);
        DBHelper.save(product1);
        Product product2 = new Product("Trowel and Square", 595, "This excavation tool is double ended giving a combination of a small trowel and square. It is particularly useful for delicate work when care and precision need to be taken.", subCategory1, "/images/leaftrowel.png", shop);
        DBHelper.save(product2);
        Product product3 = new Product("Soft Handled WHS Trowel", 1175, "As an alternative to the wooden handled 4\" archaeologists trowel, we also offer this comfortable soft grip version.  Many people find the comfortable grip preferable.", subCategory1, "/images/softtrowel.png", shop);
        DBHelper.save(product3);

        Product product4 = new Product("Square Mouth Shovel", 1175, "Drop forged and heat treated steel head with D shaped polypropylene handle - 100cm long.", subCategory2, "/images/shovel.png", shop);
        DBHelper.save(product4);
        Product product5 = new Product("Border Spade", 1100, "Drop forged steel head with polypropylene D shaped handle - 93cm long.", subCategory2, "/images/spade.png", shop);
        DBHelper.save(product5);
        Product product6 = new Product("Spear & Jackson 5lb Mattock", 1795, "The 5lb Grubbing Mattock with heat treated carbon steel head is fitted with a standard wooden handle. For heavy excavation work in archaeology. Weight - 2.3Kg (5lbs).", subCategory2, "/images/mattock.png", shop);
        DBHelper.save(product6);

        Product product7 = new Product("Hand Brush", 250, "Hand brush with wooden handle. Fitted with stiff coco bristles.", subCategory3, "/images/handbrush.png", shop);
        DBHelper.save(product7);
        Product product8 = new Product("14lt Trug Bucket", 450, "Once you have used these, you won't go back - outlasts standard plastic buckets by a mile!", subCategory3, "/images/trug.png", shop);
        DBHelper.save(product8);

        Product product9 = new Product("Tarpaulin 6 x 8ft", 1795, "Keep the spoilheap back from the edge of the trench for safety and to allow a clean edge for trench photography.", subCategory4, "/images/tarp.png", shop);
        DBHelper.save(product9);
        Product product10 = new Product("Stainless Steel Sieve", 2200, "Stainless Steel Sieve with 3 graded inserts 2mm, 4mm & 7mm. 30cm (12\") diameter x 7cm (3\") depth.", subCategory4, "/images/seive.png", shop);
        DBHelper.save(product10);

        Product product11 = new Product("Gridded Permatrace 25 Sheets", 1600, "Archival quality, dimensionally stable and printed on 50micron drafting film.", subCategory5, "/images/permatrace.png", shop);
        DBHelper.save(product11);

        Product product12 = new Product("Contour Gauge 127mm", 495, "Contour or Profile Gauges are an invaluable aid for copying curved shapes such as profiles of ceramic and architectural features.", subCategory6, "/images/gauge.png", shop);
        DBHelper.save(product12);

        Product product21 = new Product("Aluminium Line Level", 320, "An aluminium line level will always be better than the plastic alternative. This is lighter and more durable and the hook sits better on the string line.", subCategory13, "/images/linelevel.png", shop);
        DBHelper.save(product21);


        subCategory1.addProduct(product1);
        subCategory1.addProduct(product2);
        subCategory1.addProduct(product3);
        subCategory2.addProduct(product4);
        subCategory2.addProduct(product5);
        subCategory2.addProduct(product6);
        subCategory3.addProduct(product7);
        subCategory3.addProduct(product8);
        subCategory4.addProduct(product9);
        subCategory4.addProduct(product10);
        subCategory5.addProduct(product11);
        subCategory6.addProduct(product12);


        subCategory13.addProduct(product21);

        DBHelper.createUser("Mortimer Wheeler", "SirMorty1872");
        List<User> allUsers = DBHelper.getAll(User.class);
        User user = allUsers.get(0);

        shop.addToStock(product1, 10);
        DBHelper.save(product1);
        shop.addToStock(product2, 10);
        DBHelper.save(product2);
        shop.addToStock(product3, 10);
        DBHelper.save(product3);
        shop.addToStock(product4, 10);
        DBHelper.save(product4);
        shop.addToStock(product5, 10);
        DBHelper.save(product5);
        shop.addToStock(product6, 10);
        DBHelper.save(product6);
        shop.addToStock(product7, 10);
        DBHelper.save(product7);
        shop.addToStock(product8, 10);
        DBHelper.save(product8);
        shop.addToStock(product9, 10);
        DBHelper.save(product9);
        shop.addToStock(product10, 10);
        DBHelper.save(product10);
        shop.addToStock(product11, 10);
        DBHelper.save(product11);
        shop.addToStock(product12, 10);
        DBHelper.save(product12);
        shop.addToStock(product21, 10);
        DBHelper.save(product21);

        DBHelper.createOrder(user, product1, 3);
        DBHelper.createOrder(user, product4, 5);

    }
}
