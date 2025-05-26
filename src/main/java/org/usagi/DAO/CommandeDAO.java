package org.usagi.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.usagi.mapper.CommandeRowMapper;
import org.usagi.model.CommandeModel;

public class CommandeDAO implements DAO<CommandeModel> {

    private final JdbcTemplate jdbcTemplate;

    public CommandeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<CommandeModel> get(String id) {
        String sql = "SELECT * FROM commande WHERE idcom = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, new CommandeRowMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<CommandeModel> getAll() {
        String sql = "SELECT * FROM commande";
        return jdbcTemplate.query(sql, new CommandeRowMapper());
    }

    @Override
    public int save(CommandeModel t) {
        String sql = "INSERT INTO commande (idcom, idplat, nomcli, typecom, idtable, datecom) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, t.getIdcom(), t.getIdplat(), t.getNomcli(), t.getTypecom(), t.getIdtable(), t.getDatecom());
    }

    @Override
    public int update(CommandeModel t, CommandeModel updateValue) {
        StringBuilder sql = new StringBuilder("UPDATE commande SET ");
        List<Object> params = new ArrayList<>();

        if (updateValue.getIdtable() != null) {
            sql.append("idtable = ?, ");
            params.add(updateValue.getIdtable());
        }

        if (updateValue.getTypecom() != null) {
            sql.append("typecom = ?, ");
            params.add(updateValue.getTypecom());
        }

        if (updateValue.getNomcli() != null) {
            sql.append("nomcli = ?, ");
            params.add(updateValue.getNomcli());
        }

        if (updateValue.getIdplat() != null) {
            sql.append("idplat = ?, ");
            params.add(updateValue.getIdplat());
        }

        if (params.isEmpty()) {
            return 0; // No fields to update
        }

        sql.setLength(sql.length() - 2);
        sql.append(" WHERE idcom = ?");
        params.add(t.getIdcom());

        int updatedRow = jdbcTemplate.update(sql.toString(), params.toArray());

        if (updatedRow == 1) {
            if (updateValue.getIdtable() != null) {
                t.setIdtable(updateValue.getIdtable());
            }
            if (updateValue.getTypecom() != null) {
                t.setTypecom(updateValue.getTypecom());
            }
            if (updateValue.getNomcli() != null) {
                t.setNomcli(updateValue.getNomcli());
            }
            if (updateValue.getIdplat() != null) {
                t.setIdplat(updateValue.getIdplat());
            }
            
        }

        return updatedRow;
    }

    @Override
    public int delete(CommandeModel t) {
        String sql = "DELETE FROM commande WHERE idcom = ?";
        return jdbcTemplate.update(sql, t.getIdcom());
    }

}
