package com.sp.stockmanager.request;

import com.fasterxml.jackson.annotation.*;
import com.sp.stockmanager.order.Order;
import com.sp.stockmanager.product.Product;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "request_date", nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate requestDate;

    @Column(name = "acceptance_date")
    @JsonFormat(pattern="dd-MM-yyyy")
    @Nullable
    private LocalDate acceptanceDate;

    @Column
    @Nullable
    private Boolean accepted;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    public Request(Integer quantity, LocalDate requestDate, @Nullable LocalDate acceptanceDate, @Nullable boolean accepted, Product product, Order order) {
        this.quantity = quantity;
        this.requestDate = requestDate;
        this.acceptanceDate = acceptanceDate;
        this.accepted = accepted;
        this.product = product;
        this.order = order;
    }

    public Request() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    @Nullable
    public LocalDate getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(@Nullable LocalDate acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    @Nullable
    public Boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(@Nullable Boolean accepted) {
        this.accepted = accepted;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
