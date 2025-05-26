package org.usagi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.usagi.model.TableModel;

public class TableRowMapper implements RowMapper<TableModel> {
    @Override
    @Nullable
    public TableModel mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        return new TableModel(
            rs.getString("idtable"),
            rs.getString("nomtable"),
            rs.getBoolean("occupation")
        );
    }
}
