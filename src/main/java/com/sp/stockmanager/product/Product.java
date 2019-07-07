package com.sp.stockmanager.product;

import com.fasterxml.jackson.annotation.*;
import com.sp.stockmanager.record.Record;
import com.sp.stockmanager.request.Request;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private Integer stock;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Request> requests;

    @OneToOne(mappedBy = "product")
    @JsonIgnore
    private Record record;

    public Product() {
    }

    public void changeStock(int val){
        this.stock += val;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
