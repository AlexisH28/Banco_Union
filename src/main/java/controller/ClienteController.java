package controller;

import model.dao.ClienteDAO;
import model.entities.Cliente;
import model.factories.DAOFactory;
import java.util.List;

public class ClienteController {
    private final ClienteDAO clienteDAO;

    public ClienteController(DAOFactory factory) {
        this.clienteDAO = factory.getClienteDAO();
    }

    public List<Cliente> obtenerClientes() {
        return clienteDAO.findAll();
    }

    public Cliente obtenerClientePorId(int id) {
        return clienteDAO.findById(id);
    }
}

