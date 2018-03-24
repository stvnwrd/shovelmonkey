package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    private int id;
    private List<Product> products;

    public Basket {
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

    @OneToOne(fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
