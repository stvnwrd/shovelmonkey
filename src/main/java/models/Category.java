package models;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private String title;
    private List<SubCategory> subCategories;

    public Category(String title, ArrayList<SubCategory> subCategories) {
        this.title = title;
        this.subCategories = new ArrayList<>();
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

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
