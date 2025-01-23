package model.dao;

import model.entities.Cliente;
import java.util.List;

public interface ClienteDAO extends GenericDAO<Cliente> {

    // Buscar clientes inactivos.
    List<Cliente> findInactiveClients();
}
