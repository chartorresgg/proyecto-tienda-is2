package co.poli.edu.cguzman.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import co.poli.edu.cguzman.modelo.Cliente;

// Implementación de la interfaz GenericDAO para la entidad Cliente
public class ClienteImplementacionDAO implements GenericDAO<Cliente, String> {

	// Inserta un nuevo cliente en la base de datos
	@Override
	public void create(Cliente cliente) {
		String sql = "INSERT INTO Cliente (id, nombre) VALUES (?, ?)";
		try (Connection conn = GestionConexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cliente.getId());
			stmt.setString(2, cliente.getNombre());
			stmt.executeUpdate();
			System.out.println("El cliente fue insertado correctamente en la base de datos.");
		} catch (SQLException e) {
			System.err.println("Error al insertar el cliente: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene un cliente de la base de datos a partir de su ID.
	 * 
	 * @param id El ID del cliente a buscar.
	 * @return El cliente encontrado, o null si no se encontró ningún cliente con el
	 *         ID especificado.
	 */
	@Override
	public Cliente read(String id) {
		String sql = "SELECT * FROM Cliente WHERE id = ?";
		try (Connection conn = GestionConexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Crear y devolver un objeto Cliente con los datos obtenidos
				return new Cliente(rs.getString("id"), rs.getString("nombre"));
			}
		} catch (SQLException e) {
			System.err.println("Error al buscar el cliente: " + e.getMessage());
			e.printStackTrace();
		}
		return null; // Si no se encuentra el cliente, se devuelve null
	}

	@Override
	public void update(Cliente cliente) {
		String sql = "UPDATE Cliente SET nombre = ? WHERE id = ?";
		try (Connection conn = GestionConexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getId());
			int rowsUpdated = stmt.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Cliente actualizado correctamente.");
			} else {
				System.out.println("No se encontró un cliente con el ID: " + cliente.getId());
			}
		} catch (SQLException e) {
			System.err.println("Error al actualizar el cliente: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) throws SQLException {
		String sql = "DELETE FROM Cliente WHERE id = ?";
		try (Connection conn = GestionConexion.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			int rowsDeleted = stmt.executeUpdate();

			if (rowsDeleted > 0) {
				System.out.println("Cliente eliminado correctamente.");
			} else {
				System.out.println("No se encontró un cliente con el ID: " + id);
			}
		} catch (SQLException e) {
			System.err.println("Error al eliminar el cliente: " + e.getMessage());
			e.printStackTrace();
			throw e; // Relanzar la excepción para manejarla en capas superiores si es necesario.
		}
	}

	@Override
	public List<Cliente> findAll() throws SQLException {
		return null;
	}
}