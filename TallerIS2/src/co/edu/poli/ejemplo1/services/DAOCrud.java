package co.edu.poli.ejemplo1.services;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz genérica para operaciones CRUD en la base de datos. Define métodos
 * para crear, leer, actualizar y eliminar registros de una entidad T.
 *
 * @param <T> Tipo de la entidad que manejará el DAO.
 */
public interface DAOCrud<T> {

	void create(T t) throws SQLException;

	T read(String id);

	void update(T t);

	void delete(String id);

	List<T> findAll() throws SQLException;
}