package models;

import db.DBHelper;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="shop")
public class Shop {


    private int id;
    private List<Product> stock;

    public Shop(List<Product> stock) {
        this.stock = stock;
    }

    public Shop() {
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

    @OneToMany(mappedBy = "shop")
    public List<Product> getStock() {
        return stock;
    }

    public void setStock(List<Product> stock) {
        this.stock = stock;
    }

    public int stockCount() {
        return this.stock.size();
    }

    public void addToStock (Product product, int quantity) {
        for(int i=0;i<quantity;i++){
            stock.add(product);
        }
        product.increaseStockQuantity(quantity);
    }

    public void reduceStock (Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            stock.remove(product);
        }
        product.decreaseStockQuantity(quantity);
    }
}
