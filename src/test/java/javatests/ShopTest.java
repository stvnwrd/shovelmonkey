package javatests;

import models.Category;
import models.Product;
import models.Shop;
import models.SubCategory;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ShopTest {

    Category category1;
    Category category2;

    SubCategory subCategory1;
    SubCategory subCategory2;
    SubCategory subCategory3;
    SubCategory subCategory4;

    Product product1;
    Product product2;
    Product product3;
    Product product4;
    Product product5;
    Product product6;

    List<Product> stock;
    Shop shop;


    @Before
    public void setUp() throws Exception {
        category1 = new Category("Excavation");
        category2 = new Category("Recording");


        subCategory1 = new SubCategory("Trowels and Small Tools", category1);
        subCategory2 = new SubCategory("Spades, Shovels and Mattocks", category1);
        subCategory3 = new SubCategory("Drafting Film, Notebooks, and Record Sheets", category2);
        subCategory4 = new SubCategory("Gauges and Callipers", category2);

        stock = new ArrayList<>();
        shop = new Shop(stock);
        shop.addToStock(product1, 1);

        product1 = new Product("Trowel", 1599, "The finest archaeology trowel.", subCategory1, shop);
        product2 = new Product("Shovel", 1599, "For the best in shovelling.", subCategory2, shop);
        product3 = new Product("Spade", 1599, "This spade's great.", subCategory2, shop);
        product4 = new Product("Mattock", 1599, "Mattock like a champ!", subCategory2, shop);
        product5 = new Product("Permatrace", 1599, "You can certainly trace permanently on this.", subCategory3, shop);
        product6 = new Product("Line Level", 1599, "For level string, everytime.", subCategory4, shop);

        stock = new ArrayList<>();
        shop = new Shop(stock);
        shop.addToStock(product1, 1);
    }


    @Test
    public void canAddToStock() {
        shop.addToStock(product2, 3);
        assertEquals(4, shop.stockCount());
    }


}


