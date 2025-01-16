package com.enviro.assessment.grad001.katlegomaredi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Waste> waste;

    public Category() {
    }

    public Category(Integer id, String name, List<Waste> waste) {
        this.id = id;
        this.name = name;
        this.waste = waste;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Waste> getWaste() {
        return waste;
    }

    public void setWaste(List<Waste> waste) {
        this.waste = waste;
    }
}
