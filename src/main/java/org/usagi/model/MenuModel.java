package org.usagi.model;

public class MenuModel {
    private String idplat;
    public String getIdplat() {
        return idplat;
    }

    public void setIdplat(String idplat) {
        this.idplat = idplat;
    }


    private String nomplat;
    public String getNomplat() {
        return nomplat;
    }

    public void setNomplat(String nomplat) {
        this.nomplat = nomplat;
    }

    private Float pu;
    public Float getPu() {
        return pu;
    }

    public void setPu(Float pu) {
        this.pu = pu;
    }

    public MenuModel() {};

    public MenuModel(String idplat, String nomplat, Float pu) {
        this.idplat = idplat;
        this.nomplat = nomplat;
        this.pu = pu;
    }

    
}
