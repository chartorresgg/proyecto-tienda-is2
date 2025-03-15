package co.poli.edu.cguzman.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.poli.edu.cguzman.modelo.Producto;
import co.poli.edu.cguzman.modelo.ProductoAlimento;

/**
 * Implementación de la interfaz DAOCrud para gestionar operaciones CRUD de la
 * entidad Producto en la base de datos.
 */
public class ProductoImplementacionDAO implements GenericDAO<Producto, String>, ProductoDAO {

	/**
	 * Inserta un nuevo producto en la base de datos de MySQL
	 *
	 * @param producto El objeto Producto a insertar.
	 * @throws SQLException
	 */
	@Override
	public void create(Producto producto) throws SQLException {
		String sql = "INSERT INTO Producto (id, descripcion) VALUES (?, ?)";

		Connection conn = GestionConexion.obtenerConexion();
		if (conn == null) {
			throw new SQLException("No se pudo obtener conexión a la base de datos.");
		}

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
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
			throw e;
		}
	}

	/**
	 * Busca un producto en la base de datos por su ID.
	 *
	 * @param id Identificador del producto.
	 * @return El objeto Producto si se encuentra, de lo contrario, null.
	 */
	@Override
	public Producto read(String id) throws SQLException {
		String sql = "SELECT * FROM Producto WHERE id = ?";
		Connection conn = GestionConexion.obtenerConexion();
		if (conn == null) {
			throw new SQLException("No se pudo obtener conexión a la base de datos.");
		}

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new ProductoAlimento(rs.getString("id"), rs.getString("descripcion"), 0);
			}
		} catch (SQLException e) {
			System.err.println("Error al leer el producto: " + e.getMessage());
			throw e;
		}
		return null;
	}

	/**
	 * Actualiza los datos de un producto en la base de datos.
	 *
	 * @param producto El objeto Producto con los datos actualizados.
	 */
	@Override
	public void update(Producto producto) throws SQLException {
		String sql = "UPDATE Producto SET descripcion = ? WHERE id = ?";
		Connection conn = GestionConexion.obtenerConexion();
		if (conn == null) {
			throw new SQLException("No se pudo obtener conexión a la base de datos.");
		}

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, producto.getDescripcion());
			stmt.setString(2, producto.getId());

			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas == 0) {
				throw new SQLException("No se encontró el producto para actualizar.");
			}
		} catch (SQLException e) {
			System.err.println("Error al actualizar el producto: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Elimina un producto de la base de datos según su ID.
	 *
	 * @param id Identificador del producto a eliminar.
	 */
	@Override
	public void delete(String id) throws SQLException {
		String sql = "DELETE FROM Producto WHERE id = ?";
		Connection conn = GestionConexion.obtenerConexion();
		if (conn == null) {
			throw new SQLException("No se pudo obtener conexión a la base de datos.");
		}

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);

			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas == 0) {
				throw new SQLException("No se encontró el producto para eliminar.");
			}
		} catch (SQLException e) {
			System.err.println("Error al eliminar el producto: " + e.getMessage());
			throw e;
		}
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

	/**
	 * Busca productos en la base de datos cuyo precio sea mayor al valor
	 * especificado.
	 *
	 * @param price Precio mínimo de los productos a buscar.
	 * @return Una lista de productos cuyo precio es mayor al valor especificado.
	 * @throws SQLException Si ocurre un error al acceder a la base de datos.
	 */
	@Override
	public List<Producto> findByPriceGreaterThan(double price) throws SQLException {

		List<Producto> productos = new ArrayList<>();
		String sql = "SELECT id, descripcion FROM Producto WHERE precio > ?";

		// Se obtiene una conexión a la base de datos y se prepara la consulta SQL.
		// Se usa PreparedStatement para evitar inyección de SQL.
		Connection conn = GestionConexion.obtenerConexion();
		if (conn == null) {
			throw new SQLException("No se pudo obtener conexión a la base de datos.");
		}

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			// Se asigna el valor del precio con stmt.setDouble() y se ejecuta la consulta
			// con stmt.executeQuery().
			// Se recorre el ResultSet y se crea un objeto Producto con los datos obtenidos.
			// Se añade el objeto Producto a la lista de productos.
			stmt.setDouble(1, price);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String descripcion = rs.getString("descripcion");
				Producto producto = new ProductoAlimento(id, descripcion, 0);
				productos.add(producto);
			}
		} catch (SQLException e) {
			System.err.println("Error al consultar productos: " + e.getMessage());
			throw e;
		}
		return productos;
	}
}