package models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="baskets")
public class Basket {

    private int id;
    private User user;
    private List<Order> orders;
    private int totalTradeCost;
    private int totalVatCost;
    private int totalCost;
    private int totalItems;


    public Basket() {
        this.orders = new ArrayList<>();
        this.totalTradeCost = 0;
        this.totalVatCost = 0;
        this.totalCost = 0;
        this.totalItems = 0;
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

    @OneToMany(mappedBy = "basket")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> order) {
        this.orders = order;
    }

    @Column(name="total_trade_cost")
    public int getTotalTradeCost() {
        return totalTradeCost;
    }

    public void setTotalTradeCost(int totalCost) {
        this.totalTradeCost = totalCost;
    }

    @Column(name="total_vat_cost")
    public int getTotalVatCost() {
        return totalVatCost;
    }

    public void setTotalVatCost(int totalVatCost) {
        this.totalVatCost = totalVatCost;
    }

    @Column(name="total_cost")
    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @Column(name="total_items")
    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int orderCount() {
        return this.orders.size();
    }

    public void addOrder(Order order) {
            orders.add(order);
    }

    public void removeOrder(Order order) {
            orders.remove(order);
    }

    public void clearBasket() {
        orders.clear();
    }

    public void adjustTotalCost() {
        int tradeResult = 0;
        int vatResult = 0;
        for (Order order : orders) {
            tradeResult = tradeResult + (order.getProduct().getPrice() * order.getQuantity());
            vatResult = vatResult + (order.getProduct().getVat() * order.getQuantity());
        }
        this.setTotalTradeCost(tradeResult);
        this.setTotalVatCost(vatResult);
        this.setTotalCost(tradeResult + vatResult);
    }

    public void adjustTotalItems() {
        int result = 0;
        for (Order order : orders) {
            result = result + order.getQuantity();
        }
        this.setTotalItems(result);
    }
}
