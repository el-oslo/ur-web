package org.usagi.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.usagi.mapper.ReserverRowMapper;
import org.usagi.model.ReserverModel;

public class ReserverDAO implements DAO<ReserverModel> {
    private final JdbcTemplate jdbcTemplate;

    public ReserverDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<ReserverModel> get(String id) {
        String sql = "SELECT * FROM reserver WHERE idreserve = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, new ReserverRowMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<ReserverModel> getAll() {
        String sql = "SELECT * FROM reserver";
        return jdbcTemplate.query(sql, new ReserverRowMapper());
    }

    @Override
    public int save(ReserverModel t) {
        String sql = "INSERT INTO reserver (idreserve, idtable, date_de_reserv, date_reserve, nomcli) VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql, t.getIdreserv(), t.getIdtable(), t.getDate_de_reserv(), t.getDate_reserve(),
                t.getNomcli());
    }

    @Override
    public int update(ReserverModel t, ReserverModel updateValue) {
        StringBuilder sql = new StringBuilder("UPDATE reserver SET ");
        List<Object> params = new ArrayList<>();

        if (updateValue.getIdtable() != null) {
            sql.append("idtable = ?, ");
            params.add(updateValue.getIdtable());
        }
        if (updateValue.getDate_reserve() != null) {
            sql.append("date_reserve = ?, ");
            params.add(updateValue.getDate_reserve());
        }
        if (updateValue.getNomcli() != null) {
            sql.append("nomcli = ?, ");
            params.add(updateValue.getNomcli());
        }
        if (params.isEmpty()) {
            return 0; // No fields to update
        }

        sql.setLength(sql.length() - 2); // Remove the last comma and space
        sql.append(" WHERE idreserve = ?");
        params.add(t.getIdreserv());

        int updatedRow = jdbcTemplate.update(sql.toString(), params.toArray());

        if (updatedRow == 1) {
            if (updateValue.getIdtable() != null) {
                t.setIdtable(updateValue.getIdtable());
            }
            if (updateValue.getDate_reserve() != null) {
                t.setDate_reserve(updateValue.getDate_reserve());
            }
            if (updateValue.getNomcli() != null) {
                t.setNomcli(updateValue.getNomcli());
            }
        }

        return updatedRow;
    }

    @Override
    public int delete(ReserverModel t) {
        String sql = "DELETE FROM reserver WHERE idreserve = ?";
        return jdbcTemplate.update(sql, t.getIdreserv());
    }
}
