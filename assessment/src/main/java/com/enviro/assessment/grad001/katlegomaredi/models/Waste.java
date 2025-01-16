package com.enviro.assessment.grad001.katlegomaredi.models;

import java.util.List;

public class Waste {
    private Integer id;
    private String name;
    private Category category;
    private List<RecyclingTips> recyclingTips;
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
