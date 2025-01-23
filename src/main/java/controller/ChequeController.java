package controller;

import model.dao.ChequeDAO;
import model.entities.Cheque;
import model.factories.DAOFactory;

import java.util.List;

public class ChequeController {
    private final ChequeDAO chequeDAO;

    public ChequeController(DAOFactory factory) {
        this.chequeDAO = factory.getChequeDAO();
    }

    public List<Cheque> obtenerCheques() {
        return chequeDAO.findAll();
    }

    public Cheque obtenerChequePorId(int id) {
        return chequeDAO.findById(id);
    }

    public boolean agregarCheque(Cheque cheque) {
        return chequeDAO.emitirCheque(cheque);
    }

}
