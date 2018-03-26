package models;

import  javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sub_categories")
public class SubCategory {

    private int id;
    private String title;
    private Category category;
    private List<Product> products;

    public SubCategory(String title, Category category) {
        this.title = title;
        this.category = category;
        this.products = new ArrayList<>();
    }

    public SubCategory() {
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "subCategory")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
