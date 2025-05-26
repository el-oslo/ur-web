package org.usagi.model;

import java.time.LocalDateTime;

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

    private LocalDateTime date_de_reserv;
    public LocalDateTime getDate_de_reserv() {
        return date_de_reserv;
    }

    public void setDate_de_reserv(LocalDateTime date_de_reserv) {
        this.date_de_reserv = date_de_reserv;
    }

    private LocalDateTime date_reserve;
    public LocalDateTime getDate_reserve() {
        return date_reserve;
    }

    public void setDate_reserve(LocalDateTime date_reserve) {
        this.date_reserve = date_reserve;
    }

    private String nomcli;
      public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public ReserverModel() {}

    public ReserverModel(String idreserv, String idtable, LocalDateTime date_de_reserv, LocalDateTime date_reserve, String nomcli) {
        this.idreserv = idreserv;
        this.idtable = idtable;
        this.date_de_reserv = date_de_reserv;
        this.date_reserve = date_reserve;
        this.nomcli = nomcli;
    }
}
