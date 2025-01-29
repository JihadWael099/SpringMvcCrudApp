package com.adminPanel.app.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 1,max = 100,message = "write a valid name ")
    private String name;

    @Column(name = "expiration_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Expiration date cannot be null")
    private Date expirationDate;

    @Column(name = "manufacturer")
    @NotBlank(message = "Manufacturer cannot be blank")
    @Size(min = 1,max = 100,message = "write a valid name ")
    private String manufacturer;

    @Column(name = "price")
    @NotNull(message = "Price cannot be null")
    @Min(value = 1,message = "zero or negative not allow")
    private Double price;

    @Column(name = "available")
    @NotNull(message = "Availability cannot be null")
    private Boolean available;


    @Valid
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductDetails(String name, Date expirationDate, String manufacturer, Double price, Boolean available, Product product) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.available = available;
        this.product = product;
    }

    public ProductDetails(String name, Date expirationDate, String manufacturer, Double price, Boolean available) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.available = available;
    }
}