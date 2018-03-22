package models;

import java.util.HashMap;
import java.util.Map;

public class Shop {

    private int id;
    private Map<Product, Integer> stocklist;

    public Shop() {
        this.stocklist = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Product, Integer> getStocklist() {
        return stocklist;
    }

    public void setStocklist(Map<Product, Integer> stocklist) {
        this.stocklist = stocklist;
    }
}
