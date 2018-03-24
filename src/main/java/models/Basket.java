package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="baskets")
public class Basket {

    private int id;
    private User user;
    private List<Product> products;


    public Basket() {
        this.products = new ArrayList<>();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="basket_food",
            joinColumns = {@JoinColumn(name="basket_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="product_id", nullable = false, updatable = false)})
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
