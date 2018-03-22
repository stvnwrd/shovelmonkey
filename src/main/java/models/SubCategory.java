package models;

import java.util.ArrayList;
import java.util.List;

public class SubCategory {

    private int id;
    private String title;
    private List<Product> products;

    public SubCategory(String title, List<Product> products) {
        this.title = title;
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
