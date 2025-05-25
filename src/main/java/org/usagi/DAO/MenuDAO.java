package org.usagi.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.usagi.mapper.MenuRowMapper;
import org.usagi.model.MenuModel;

public class MenuDAO implements DAO<MenuModel> {

    private final JdbcTemplate jdbcTemplate;

    public MenuDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<MenuModel> get(String id) {
        String sql = "SELECT * FROM menu WHERE idplat = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, new MenuRowMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<MenuModel> getAll() {
        String sql = "SELECT * FROM menu";
        return jdbcTemplate.query(sql, new MenuRowMapper());
    }

    @Override
    public int save(MenuModel t) {
        String sql = "INSERT INTO menu (idplat, nomplat, pu) VALUES(?,?,?)";
        return jdbcTemplate.update(sql, t.getIdplat(), t.getNomplat(), t.getPu());
    }

    @Override
    public int update(MenuModel t, MenuModel newValues) {
        StringBuilder sql = new StringBuilder("UPDATE menu SET ");
        List<Object> params = new ArrayList<>();

        if (newValues.getNomplat() != null) {
            sql.append("nomplat = ?, ");
            params.add(newValues.getNomplat());
        }

        if (newValues.getPu() != null) {
            sql.append("pu = ?, ");
            params.add(newValues.getPu());
        }

        if (params.isEmpty()) {
            return 0;
        }

        sql.setLength(sql.length() - 2); // Remove the last ", "
        sql.append(" WHERE idplat = ?");
        params.add(t.getIdplat());

        int updatedRow = jdbcTemplate.update(sql.toString(), params.toArray());

        if (updatedRow == 1) {
            if (newValues.getNomplat() != null) {
                t.setNomplat(newValues.getNomplat());
            }
            if (newValues.getPu() != null) {
                t.setPu(newValues.getPu());
            }
        }
        return updatedRow;
    }

    @Override
    public int delete(MenuModel t) {
        String sql = "DELETE FROM menu WHERE idplat = ?";
        return jdbcTemplate.update(sql, t.getIdplat());
    }

}
