package co.poli.edu.cguzman.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GestionConexion {

    private static Connection conexion;
    private static final ResourceBundle propiedades = ResourceBundle.getBundle("database");

    private GestionConexion() {
    }

    /**
     * Obtiene una conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     * @throws SQLException Si ocurre un error al conectar a la base de datos.
     */
    public static synchronized Connection obtenerConexion() throws SQLException {
        if (conexion == null || esConexionCerrada()) {
            try {
                String URL = propiedades.getString("db.url");
                String USUARIO = propiedades.getString("db.user");
                String CONTRASEÑA = propiedades.getString("db.password");

                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
                return conexion;
            } catch (SQLException e) {
                throw new SQLException("Error al conectar con la base de datos: " + e.getMessage(), e);
            }
        }
        return conexion;
    }

    private static boolean esConexionCerrada() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            return true;
        }
        return false;
    }

    public static void cerrarConexion() throws SQLException {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar la conexión: " + e.getMessage(), e);
            }
        }
    }
}
