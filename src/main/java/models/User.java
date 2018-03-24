package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
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

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @OneToMany(mappedBy = "user")
    public List<PastOrder> getPastOrders() {
        return pastOrders;
    }

    public void setPastOrders(List<PastOrder> pastOrders) {
        this.pastOrders = pastOrders;
    }

}
