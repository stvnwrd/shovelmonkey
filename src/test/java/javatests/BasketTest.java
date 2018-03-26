package javatests;

import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    Basket basket;
    User user;
    Order order1;
    Order order2;
    Order order3;
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
    List<Order> orders;
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


        product1 = new Product("Trowel", 1599, "The finest archaeology trowel.", subCategory1, shop);
        product2 = new Product("Shovel", 1599, "For the best in shovelling.", subCategory2, shop);
        product3 = new Product("Spade", 1599, "This spade's great.", subCategory2, shop);
        product4 = new Product("Mattock", 1599, "Mattock like a champ!", subCategory2, shop);
        product5 = new Product("Permatrace", 1599, "You can certainly trace permanently on this.", subCategory3, shop);
        product6 = new Product("Line Level", 1599, "For level string, everytime.", subCategory4, shop);

//        orders = new ArrayList<>();
        basket = new Basket();

        user = new User("Jeff Bridges", "Jeffster72", basket);

        order1 = new Order(product1, 2);
        order2 = new Order(product2, 3);
        order3 = new Order(product3, 1);

        basket.addOrder(order1);
        basket.addOrder(order2);
    }

    @Test
    public void canAddToBasket() {
        basket.addOrder(order3);
        assertEquals(3, basket.orderCount());
    }

    @Test
    public void canRemoveFromBasket() {
        basket.removeOrder(order1);
        assertEquals(1, basket.orderCount());
    }

    @Test
    public void canKeepTotalTradeAndVatCost() {
        basket.adjustTotalCost();
        assertEquals(7995, basket.getTotalTradeCost());
        assertEquals(1595, basket.getTotalVatCost());
    }

    @Test
    public void canKeepTotalItems() {
        basket.adjustTotalItems();
        assertEquals(5, basket.getTotalItems());
    }
}
