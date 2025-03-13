package co.poli.edu.cguzman.services;


import java.sql.SQLException; //Importación de la clase SQLException para manejar errores de la base de datos.
import java.util.List; //Importación de la clase List para trabajar con colecciones de objetos de cualquier entidad (T).

/**
 * Interfaz genérica para operaciones CRUD en la base de datos. Define métodos
 * para crear, leer, actualizar y eliminar registros de una entidad T.
 *
 * @param <T> Tipo de la entidad que manejará el DAO: Puede ser Producto,
 *            Cliente, Pedido, etc.
 * @param <K> Tipo de la clave primaria de la entidad: Puede ser String,
 *            Integer, Long, etc.
 */
public interface GenericDAO<T, K> { // Declaración de la interfaz genérica. T: tipo de entidad, K: tipo de clave
									// primaria

	void create(T entity) throws SQLException; // Insertar un nuevo registro de tipo T en la BD.

	T read(K id) throws SQLException; // Obtiene un registro de tipo T de la BD usando la PK K.

	void update(T entity) throws SQLException; // Actualiza un registro existente de tipo T en la BD.

	void delete(K id) throws SQLException; // Elimina un registro de tipo T de la BD usando la PK K.

	List<T> findAll() throws SQLException; // Obtiene todos los registros de tipo T de la BD.

}