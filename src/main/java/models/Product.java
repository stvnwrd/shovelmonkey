package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
public class Product {

    private int id;
    private String name;
    private int price;
    private int vat;
    private int totalPrice;
    private String blurb;
    private SubCategory subCategory;
    private Shop shop;
    private List<Order> orders;
    private int stockQuantity;
    private String image;


    public Product(String name, int price, String blurb, SubCategory subCategory, String image, Shop shop) {
        this.name = name;
        this.price = price;
        this.vat = (int)(price * 0.2);
        this.totalPrice = this.price + this.vat;
        this.blurb = blurb;
        this.subCategory = subCategory;
        this.image = image;
        this.shop = shop;
        this.orders = new ArrayList<>();
        this.stockQuantity = 0;

    }

    public Product() {
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "vat")
    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    @Column(name = "total_price")
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column(name = "blurb")
    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subCategory_id", nullable = false)
    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    @Column(name="image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @OneToMany(mappedBy = "product")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Column(name="quantity")
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


    public void increaseStockQuantity(int quantity) {
        int stockQuantity = this.getStockQuantity() + quantity;
        this.setStockQuantity(stockQuantity);

    }

    public void decreaseStockQuantity(int quantity) {
        int stockQuantity = this.getStockQuantity() - quantity;
        this.setStockQuantity(stockQuantity);

    }

    public double decimalFormat(int amount) {
       double result = amount / 100.0;
       return result;
    }


}
