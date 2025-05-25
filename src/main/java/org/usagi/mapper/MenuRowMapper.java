package org.usagi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.usagi.model.MenuModel;

public class MenuRowMapper implements RowMapper<MenuModel> {
    @Override
    @Nullable
    public MenuModel mapRow(@org.springframework.lang.NonNull ResultSet rs, int rowNum) throws SQLException {
        return new MenuModel(
            rs.getString("idplat"),
            rs.getString("nomplat"),
            rs.getFloat("pu")
        );
    }

}
