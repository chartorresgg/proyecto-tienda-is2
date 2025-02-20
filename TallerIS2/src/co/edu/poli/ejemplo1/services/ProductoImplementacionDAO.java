package co.edu.poli.ejemplo1.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import co.edu.poli.ejemplo1.model.Producto;

/**
 * Implementación de la interfaz DAOCrud para gestionar operaciones CRUD de la
 * entidad Producto en la base de datos.
 */
public class ProductoImplementacionDAO implements DAOCrud<Producto> {

	/**
	 * Inserta un nuevo producto en la base de datos.
	 *
	 * @param producto El objeto Producto a insertar.
	 */
	@Override
	public void create(Producto producto) {
		String sql = "INSERT INTO Producto (id, descripcion) VALUES (?, ?)";

		try (Connection conn = GestionConexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			if (conn == null) {
				throw new SQLException("No se pudo obtener conexión a la base de datos.");
			}

			stmt.setString(1, producto.getId());
			stmt.setString(2, producto.getDescripcion());

			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("El producto fue insertado correctamente.");
			} else {
				System.out.println("No se pudo insertar el producto.");
			}

		} catch (SQLException e) {
			System.err.println("Error al insertar el producto: " + e.getMessage());
		}
	}

	/**
	 * Busca un producto en la base de datos por su ID.
	 *
	 * @param id Identificador del producto.
	 * @return El objeto Producto si se encuentra, de lo contrario, null.
	 */
	@Override
	public Producto read(String id) {
		// Implementación pendiente
		return null;
	}

	/**
	 * Actualiza los datos de un producto en la base de datos.
	 *
	 * @param producto El objeto Producto con los datos actualizados.
	 */
	@Override
	public void update(Producto producto) {
		// Implementación pendiente
	}

	/**
	 * Elimina un producto de la base de datos según su ID.
	 *
	 * @param id Identificador del producto a eliminar.
	 */
	@Override
	public void delete(String id) {
		// Implementación pendiente
	}

	/**
	 * Recupera todos los productos almacenados en la base de datos.
	 *
	 * @return Una lista de todos los productos.
	 * @throws SQLException Si ocurre un error al acceder a la base de datos.
	 */
	@Override
	public List<Producto> findAll() throws SQLException {
		// Implementación pendiente
		return null;
	}
}