package models;

import java.util.HashMap;
import java.util.Map;

public class User {

    private int id;
    private String name;
    private String userName;
    private Map<Product, Integer> basket;


    public User(String name, String userName) {
        this.name = name;
        this.userName = userName;
        this.basket = new HashMap<>();

    }

//    EMPTY CONSTUCTOR!

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<Product, Integer> getBasket() {
        return basket;
    }

    public void setBasket(Map<Product, Integer> basket) {
        this.basket = basket;
    }
}
