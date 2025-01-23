package model.dao.impl;

import model.dao.ClienteDAO;
import model.entities.Cliente;
import model.database.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    private Connection connection;

    public ClienteDAOImpl() {
        try {
            this.connection = ConexionDB.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> findInactiveClients() {
        String sql = "SELECT * FROM clientes WHERE estado = 'Inactivo'";
        List<Cliente> clientesInactivos = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("identificacion"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("estado")
                );
                clientesInactivos.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientesInactivos;
    }

    @Override
    public Cliente findById(int id) {
        // Implementación opcional si se requiere.
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        // Implementación opcional si se requiere.
        return null;
    }

    @Override
    public List<Cliente> findByCondition(String condition) {
        // Implementación genérica para condiciones personalizadas.
        return null;
    }


}
