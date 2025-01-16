package com.enviro.assessment.grad001.katlegomaredi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "waste")
public class Waste {
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "waste")
    private List<RecyclingTips> recyclingTips;
    @OneToMany(mappedBy = "waste")
    private List<DisposalTips> disposalTips;

    public Waste() {
    }

    public Waste(Integer id, String name, Category category, List<RecyclingTips> recyclingTips, List<DisposalTips> disposalTips) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.recyclingTips = recyclingTips;
        this.disposalTips = disposalTips;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<RecyclingTips> getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(List<RecyclingTips> recyclingTips) {
        this.recyclingTips = recyclingTips;
    }

    public List<DisposalTips> getDisposalTips() {
        return disposalTips;
    }

    public void setDisposalTips(List<DisposalTips> disposalTips) {
        this.disposalTips = disposalTips;
    }
}
