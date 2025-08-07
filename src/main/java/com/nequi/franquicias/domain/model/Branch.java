package com.nequi.franquicias.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "franchise_id", nullable = false)
    private Franchise franchise;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setBranch(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setBranch(null);
    }

    // Package-private setter for maintaining consistency
    void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
}
