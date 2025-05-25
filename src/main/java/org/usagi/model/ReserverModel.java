package org.usagi.model;

import java.sql.Date;

public class ReserverModel {
    private String idreserv;
    public String getIdreserv() {
        return idreserv;
    }

    public void setIdreserv(String idreserv) {
        this.idreserv = idreserv;
    }

    private String idtable;
    public String getIdtable() {
        return idtable;
    }

    public void setIdtable(String idtable) {
        this.idtable = idtable;
    }

    private Date date_de_reserv;
    public Date getDate_de_reserv() {
        return date_de_reserv;
    }

    public void setDate_de_reserv(Date date_de_reserv) {
        this.date_de_reserv = date_de_reserv;
    }

    private Date date_reserve;
    public Date getDate_reserve() {
        return date_reserve;
    }

    public void setDate_reserve(Date date_reserve) {
        this.date_reserve = date_reserve;
    }

    private String nomcli;
      public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }
}
