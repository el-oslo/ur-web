package org.usagi.mapper;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.usagi.model.ReserverModel;

public class ReserverRowMapper implements RowMapper<ReserverModel> {

    @Override
    public ReserverModel mapRow(@NonNull ResultSet rs, int rowNum) throws java.sql.SQLException {
        return new ReserverModel(
            rs.getString("idreserve"),
            rs.getString("idtable"),
            rs.getTimestamp("date_de_reserv").toLocalDateTime(),
            rs.getTimestamp("date_reserve").toLocalDateTime(),
            rs.getString("nomcli")
        );
    }
}
