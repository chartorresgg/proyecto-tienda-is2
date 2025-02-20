package co.edu.poli.ejemplo1.services;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz genérica para operaciones CRUD en la base de datos. Define métodos
 * para crear, leer, actualizar y eliminar registros de una entidad T.
 *
 * @param <T> Tipo de la entidad que manejará el DAO.
 * @param <K> Tipo de la clave primaria de la entidad.
 */
public interface GenericDAO<T, K> { // T: Tipo de entidad, K: Tipo de clave primaria

	void create(T entity) throws SQLException;

	T read(K id) throws SQLException;

	void update(T entity) throws SQLException;

	void delete(K id) throws SQLException;

	List<T> findAll() throws SQLException;

	List<T> findByPriceGreaterThan(double price) throws SQLException;

}
