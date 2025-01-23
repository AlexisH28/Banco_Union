package model.factories;

import model.dao.ChequeDAO;
import model.dao.ClienteDAO;
import model.dao.impl.ChequeDAOImpl;
import model.dao.impl.ClienteDAOImpl;

public class ConcreteDAOFactory extends DAOFactory {
    @Override
    public ClienteDAO getClienteDAO() {
        return new ClienteDAOImpl();
    }

    @Override
    public ChequeDAO getChequeDAO() {
        return new ChequeDAOImpl();
    }
}
