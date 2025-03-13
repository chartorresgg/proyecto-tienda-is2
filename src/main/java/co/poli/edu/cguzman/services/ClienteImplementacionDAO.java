package co.poli.edu.cguzman.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
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

	@Override
	public Cliente read(String id) {
		return null;
	}

	@Override
	public void update(Cliente cliente) {
	}

	@Override
	public void delete(String id) {
	}

	@Override
	public List<Cliente> findAll() throws SQLException {
		return null;
	}
}