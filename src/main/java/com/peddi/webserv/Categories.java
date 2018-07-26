package com.peddi.webserv;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Categories")
public class Categories {

    @Id
    @Column(name="catId")
    private int catId;

    @Column(name="categoryName")
    private String categoryName;

    @ManyToMany(targetEntity = Items.class, cascade = CascadeType.ALL)
    @JoinTable(name = "Categories_Items",joinColumns = @JoinColumn(name= "cat_Id_fk",referencedColumnName = "catId"))
    private Set items;

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setItems(Set items) {
        this.items = items;
    }

    public int getCatId() {
        return catId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Set getItems() {
        return items;
    }
}
