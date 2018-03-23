package models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="stock")
public class Stock {


    private int id;
    private Map<Product, Integer> stocklist;



    public Stock() {
        this.stocklist = new HashMap<>();
    }

//    EMPTY CONSTRUCTOR!


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Transient
    public Map<Product, Integer> getStocklist() {
        return stocklist;
    }

    public void setStocklist(Map<Product, Integer> stocklist) {
        this.stocklist = stocklist;
    }
}
