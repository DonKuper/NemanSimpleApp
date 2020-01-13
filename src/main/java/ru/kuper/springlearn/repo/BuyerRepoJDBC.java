package ru.kuper.springlearn.repo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kuper.springlearn.model.Buyer;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BuyerRepoJDBC implements BuyerRepo{

    private JdbcTemplate jdbcTemplate;

    public BuyerRepoJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Buyer> findAll() {
        return jdbcTemplate.query("SELECT id, name, country, token FROM buyer",this::mapRowToBuyer);
    }

    @Override
    public Buyer findById(String id) {
        return jdbcTemplate.queryForObject("SELECT id, name, country, token FROM buyer WHERE id=?",this::mapRowToBuyer,id);
    }


    @Override
    public Buyer save(Buyer buyer) {
       jdbcTemplate.update("INSERT INTO buyer (id,name,country,token) values(?,?,?,?)", buyer.getId(), buyer.getName(), buyer.getCountiry(),buyer.getToken());
       return buyer;
    }


    private Buyer mapRowToBuyer(ResultSet rs,int rowNum) throws SQLException {
        return new Buyer(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getInt("token"));
    }



}
