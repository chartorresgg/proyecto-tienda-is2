package co.edu.poli.ejemplo1.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Clase Singleton para gestionar la conexión a la base de datos MySQL.
 * Garantiza que solo haya una instancia de conexión activa en todo el sistema.
 */
public class GestionConexion {

	/**
	 * Instancia única de la clase (patrón Singleton). El atributo estático:
	 * conexion, almacena la única instancia de la conexión a la base de datos.
	 */
	private static Connection conexion;

	/**
	 * Constructor privado que inicializa la conexión a la base de datos. Impide que
	 * se creen instancias de GestionConexion fuera de la clase.Se ejecuta solo una
	 * vez al instanciar la clase.
	 */
	private GestionConexion() {
	}

	/**
	 * Método estático que devuelve la instancia única de la clase. Si la instancia
	 * no existe, se crea una nueva. ObtenerConexion() accede a la instancia única.
	 * 
	 * @return Instancia única de {@code GestionConexion}.
	 */
	public static Connection obtenerConexion() throws SQLException {
		if (conexion == null || conexion.isClosed()) {
			try {
				Properties propiedades = new Properties();
				FileInputStream entrada = new FileInputStream("config/database.properties");
				propiedades.load(entrada);

				String URL = propiedades.getProperty("db.url");
				String USUARIO = propiedades.getProperty("db.user");
				String CONTRASEÑA = propiedades.getProperty("db.password");

				conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
				System.out.println("Conexión a la base de datos establecida.");

			} catch (IOException e) {
				System.out.println("Error al leer el archivo de propiedades: " + e.getMessage());
			} catch (SQLException e) {
				System.out.println("Error al conectar con la base de datos: " + e.getMessage());
				throw e;
			}
		}
		return conexion;
	}

	/**
	 * Obtiene la conexión a la base de datos, sin necesidad de llamar a
	 * obtenerConexion().
	 * 
	 * @return Objeto {@code Connection} para interactuar con la base de datos.
	 */
	public Connection getConnection() {
		return conexion;
	}

	/**
	 * Cierra la conexión a la base de datos si está abierta.
	 */
	public static void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;
				System.out.println("Conexión cerrada correctamente.");
			} catch (SQLException e) {
				System.err.println("Error al cerrar la conexión: " + e.getMessage());
			}
		}
	}

}