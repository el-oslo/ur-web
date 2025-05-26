package org.usagi.model;

import java.time.LocalDateTime;

public class CommandeModel {
    private String idcom;
    public String getIdcom() {
        return idcom;
    }

    public void setIdcom(String idcom) {
        this.idcom = idcom;
    }

    private String idplat;
    public String getIdplat() {
        return idplat;
    }

    public void setIdplat(String idplat) {
        this.idplat = idplat;
    }

    private String nomcli;
    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    private String typecom;
    public String getTypecom() {
        return typecom;
    }
    
    public void setTypecom(String typecom) {
        this.typecom = typecom;
    }
    
    private String idtable;
    public String getIdtable() {
        return idtable;
    }

    public void setIdtable(String idtable) {
        this.idtable = idtable;
    }
 
    private LocalDateTime datecom;
    public LocalDateTime getDatecom() {
        return datecom;
    }

    public void setDatecom(LocalDateTime datecom) {
        this.datecom = datecom;
    }

    public CommandeModel() {}

    public CommandeModel(String idcom, String idplat, String nomcli, String typecom, String idtable, LocalDateTime datecom) {
        this.idcom = idcom;
        this.idplat = idplat;
        this.nomcli = nomcli;
        this.typecom = typecom;
        this.idtable = idtable;
        this.datecom = datecom;
    }
}
