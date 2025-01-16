package com.enviro.assessment.grad001.katlegomaredi.models;

public class Category {
    private Integer id;
    private String name;
    private Waste waste;

    public Category() {
    }

    public Category(Integer id, String name, Waste waste) {
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

    public Waste getWaste() {
        return waste;
    }

    public void setWaste(Waste waste) {
        this.waste = waste;
    }
}
