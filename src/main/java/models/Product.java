package models;


import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {

    private int id;
    private String name;
    private int price;
    private int vat;
    private String blurb;
    private SubCategory subCategory;


    public Product(String name, int price, String blurb, SubCategory subCategory) {
        this.name = name;
        this.price = price;
        this.blurb = blurb;
        this.subCategory = subCategory;
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
}
