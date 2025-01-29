package com.adminPanel.app.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "name can,t be null")
    @Size(min = 1,max = 100,message = "write a valid name ")
    private String name;

    @Valid
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductDetails productDetails;

    public Product(String name) {
        this.name = name;
    }
}