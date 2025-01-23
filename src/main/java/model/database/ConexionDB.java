package model.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static ConexionDB instance; // Instancia única de la clase
    private final Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/banco_union"; // URL de la base de datos
    private static final String USER = "campus2023"; // Usuario de la base de datos
    private static final String PASSWORD = "campus2023"; // Contraseña de la base de datos

    // Constructor privado para evitar instanciación externa
    private ConexionDB() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Método estático para obtener la instancia única
    public static ConexionDB getInstance() throws SQLException {
        if (instance != null) {
            return instance;
        }
        synchronized (ConexionDB.class) {
            if (instance == null) {
                instance = new ConexionDB();
            }
        }
        return instance;
    }

    // Método para obtener la conexión activa
    public Connection getConnection() {
        return connection;
    }

    // Método principal de prueba
    public static void main(String[] args) {
        try (Connection connection = ConexionDB.getInstance().getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                System.out.println("Fallo al conectar a la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error durante la prueba de conexión: " + e.getMessage());
        }
    }
}