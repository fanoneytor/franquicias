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
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> branches = new ArrayList<>();

    public Franchise(String name) {
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void addBranch(Branch branch) {
        branches.add(branch);
        branch.setFranchise(this);
    }

    public void removeBranch(Branch branch) {
        branches.remove(branch);
        branch.setFranchise(null);
    }
}
