package co.edu.poli.ejemplo1.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import co.edu.poli.ejemplo1.model.Cliente;

public class ClienteImplementacionDAO implements GenericDAO<Cliente, String> {

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

	@Override
	public List<Cliente> findByPriceGreaterThan(double price) throws SQLException {
		return null;
	}
}