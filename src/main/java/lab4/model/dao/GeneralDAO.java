package lab4.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<E> {


    List<E> findAll() throws SQLException;

    E findOne(Integer id) throws SQLException;

    void create(E object) throws SQLException;

    void update(Integer id, E object) throws SQLException;

    void delete(Integer id) throws SQLException;
}
