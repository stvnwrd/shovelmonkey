package models;


import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    private int id;
    private Product product;
    private int quantity;
    private Basket basket;


    public Order() {
    }

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.basket = basket;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name="quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id", nullable = false)
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
