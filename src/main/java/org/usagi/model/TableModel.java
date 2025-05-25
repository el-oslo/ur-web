package org.usagi.model;

public class TableModel {
    private String idtable;
    public String getId() {
        return this.idtable;
    }
    public void setId(String id) {
        this.idtable = id;
    }
    
    private String designation;
    public String getDesignation() {
        return this.designation;
    }
    public void setDesignation(String value) {
        this.designation = value;
    }
    
    private Boolean occupation;
    public Boolean getOccupation() {
        return this.occupation;
    }
    public void setOccupation(Boolean value) {
        this.occupation = value;
    }
    public void toggleOccupation() {
        this.occupation = !this.occupation;
    }

    
}
