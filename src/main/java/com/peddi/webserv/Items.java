package com.peddi.webserv;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Items")
public class Items {

    @Id
    @Column(name="itemId")
    private int itemId;

    @Column(name="itemName",length = 300)
    private String itemName;

    @ManyToMany(targetEntity = Categories.class, mappedBy = "items")
    private Set categories;

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCategories(Set categories) {
        this.categories = categories;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public Set getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", categories=" + categories +
                '}';
    }
}
