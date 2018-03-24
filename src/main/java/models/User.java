package models;

import java.util.Map;

public class User {

    private int id;
    private String name;
    private String userName;
    private Basket basket;
    private List<PastOrder> pastOrders;


    public User(String name, String userName) {
        this.name = name;
        this.userName = userName;
        this.basket = basket;
        this.pastOrders = pastOrders;

    }

    public User() {
    }

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

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<PastOrder> getPastOrders() {
        return pastOrders;
    }

    public void setPastOrders(List<PastOrder> pastOrders) {
        this.pastOrders = pastOrders;
    }
}
