package model.factories;

import model.dao.ChequeDAO;
import model.dao.ClienteDAO;

public abstract class DAOFactory {
    public abstract ClienteDAO getClienteDAO();
    public abstract ChequeDAO getChequeDAO();
}
