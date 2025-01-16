package com.enviro.assessment.grad001.katlegomaredi.models;

public class RecyclingTips {
    private Integer id;
    private String tip;
    private Waste waste;

    public RecyclingTips() {
    }

    public RecyclingTips(Integer id, String tip, Waste waste) {
        this.id = id;
        this.tip = tip;
        this.waste = waste;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Waste getWaste() {
        return waste;
    }

    public void setWaste(Waste waste) {
        this.waste = waste;
    }
}
