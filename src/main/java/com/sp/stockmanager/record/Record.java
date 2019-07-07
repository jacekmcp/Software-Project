package com.sp.stockmanager.record;

import com.sp.stockmanager.menu.Menu;
import com.sp.stockmanager.product.Product;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lot_number", nullable = false)
    private String lotNumber;

    @Column(name = "r_quantity", nullable = false)
    private int rQuantity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @Nullable
    private Menu menu;

    public Record(String lotNumber, int rQuantity, Product product, @Nullable Menu menu) {
        this.lotNumber = lotNumber;
        this.rQuantity = rQuantity;
        this.product = product;
        this.menu = menu;
    }

    public Record(String lotNumber, int rQuantity) {
        this.lotNumber = lotNumber;
        this.rQuantity = rQuantity;
    }

    public Record() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public int getrQuantity() {
        return rQuantity;
    }

    public void setrQuantity(int rQuantity) {
        this.rQuantity = rQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Nullable
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(@Nullable Menu menu) {
        this.menu = menu;
    }
}
