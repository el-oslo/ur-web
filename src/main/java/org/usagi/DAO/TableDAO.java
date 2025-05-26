package org.usagi.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.usagi.mapper.TableRowMapper;
import org.usagi.model.TableModel;


public class TableDAO implements DAO<TableModel> {

    private final JdbcTemplate jdbcTemplate;

    public TableDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    @Override
    public Optional<TableModel> get(String id) {
        String sql = "SELECT * FROM \"table\" WHERE idtable = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, new TableRowMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<TableModel> getAll() {
        String sql = "SELECT * FROM \"table\"";
        return jdbcTemplate.query(sql, new TableRowMapper()); 
    }

    @Override
    public int save(TableModel t) {
        String sql = "INSERT INTO \"table\" (idtable, designation, occupation) VALUES(?,?,?)";
        return jdbcTemplate.update(sql, t.getId(), t.getDesignation(), t.getOccupation());
    }

    @Override
    public int update(TableModel t, TableModel newValues) {
        StringBuilder sql = new StringBuilder("UPDATE \"table\" SET ");
        List<Object> params = new ArrayList<>();

        if (newValues.getDesignation() != null) {
            sql.append("designation = ?, ");
            params.add(newValues.getDesignation());
        }

        if (newValues.getOccupation() != null) {
            sql.append("occupation = ?, ");
            params.add(newValues.getOccupation());
        }

        if (params.isEmpty()) {
            return 0;
        }

        sql.setLength(sql.length() - 2); // Remove the last ", "
        sql.append(" WHERE idtable = ?");
        params.add(t.getId());

        int updatedRow = jdbcTemplate.update(sql.toString(), params.toArray());

        if (updatedRow == 1) {
            if (newValues.getDesignation() != null) {
                t.setDesignation(newValues.getDesignation());
            }
            if (newValues.getOccupation() != null) {
                t.setOccupation(newValues.getOccupation());
            }
        }

        return updatedRow;
    }

    @Override
    public int delete(TableModel t) {
        String sql = "DELETE FROM \"table\" WHERE idtable = ?";
        return jdbcTemplate.update(sql, t.getId());
    }

}
