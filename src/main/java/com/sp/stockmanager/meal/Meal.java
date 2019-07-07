package com.sp.stockmanager.meal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sp.stockmanager.menu.Menu;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String name;

    @Lob
    @Column(name="description", length=2048)
    private String description;

    @ManyToMany(mappedBy = "meals", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Menu> menus = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
