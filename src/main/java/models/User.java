package models;

import db.DBHelper;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    private int id;
    private String name;
    private String userName;
    private Basket basket;
    private Order order;
    private List<PastOrder> pastOrders;


    public User(String name, String userName, Basket basket) {
        this.name = name;
        this.userName = userName;
        this.basket = basket;
        this.pastOrders = pastOrders;

    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "username")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Transient
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public List<PastOrder> getPastOrders() {
        return pastOrders;
    }

    public void setPastOrders(List<PastOrder> pastOrders) {
        this.pastOrders = pastOrders;
    }

    public void createOrder(Product product, int quantity) {
        order = new Order(product, quantity);
        DBHelper.save(order);
        basket.addOrder(order);
    }

    public void removeOrder(int id) {
       Order orderToRemove = DBHelper.find(Order.class, id);
       basket.removeOrder(orderToRemove);
    }
}
