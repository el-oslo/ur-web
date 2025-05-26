package org.usagi.model;

public class TableModel {

    public TableModel() {
        // Default constructor
    }

    public TableModel(String idtable, String designation, Boolean occupation) {
        this.idtable = idtable;
        this.designation = designation;
        this.occupation = occupation;
    }

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
