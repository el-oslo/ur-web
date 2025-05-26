package org.usagi.mapper;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.usagi.model.CommandeModel;

public class CommandeRowMapper implements RowMapper<CommandeModel> {

    @Override
    public CommandeModel mapRow(@NonNull ResultSet rs, int rowNum) throws java.sql.SQLException {
        return new CommandeModel(
            rs.getString("idcom"),
            rs.getString("idplat"),
            rs.getString("nomcli"),
            rs.getString("typecom"),
            rs.getString("idtable"),
            rs.getTimestamp("datecom").toLocalDateTime()
        );
    }
}
