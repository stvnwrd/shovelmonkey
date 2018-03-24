package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class PastOrder {

    private int id;
    private GregorianCalendar date;
    private List<Product> products;

    public PastOrder() {
    }

    public PastOrder(GregorianCalendar date, List<Product> products) {
        this.date = date;
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

    @Column(name="date")
    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    @OneToMany
    @Column(name="products")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
