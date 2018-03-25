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
    @JoinTable(name="basket_product",
            joinColumns = {@JoinColumn(name="basket_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="product_id", nullable = false, updatable = false)})
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int productCount() {
        return this.products.size();
    }

    public void addProduct(Product product, int quantity) {
        for(int i=0;i<quantity;i++){
            products.add(product);
        }
        product.increaseBasketQuantity(quantity);
    }

    public void removeProduct(Product product, int quantity) {
        for(int i=0;i<quantity;i++){
            products.remove(product);
        }
        product.decreaseBasketQuantity(quantity);
    }
}
