package controller;

import model.factories.DAOFactory;
import model.entities.Cliente;
import model.entities.Cheque;

import java.util.List;

public class MainController {
   private final ClienteController clienteController;
    private final ChequeController chequeController;

    public MainController(DAOFactory factory) {
        this.clienteController = new ClienteController(factory);
        this.chequeController = new ChequeController(factory);
    }

    public List<Cliente> obtenerClientes() {
        return clienteController.obtenerClientes();
    }

    public Cliente obtenerClientePorId(int id) {
        return clienteController.obtenerClientePorId(id);
    }


    public List<Cheque> obtenerCheques() {
        return chequeController.obtenerCheques();
    }

    public Cheque obtenerChequePorId(int id) {
        return chequeController.obtenerChequePorId(id);
    }

    public boolean agregarCheque(Cheque cheque) {
        return chequeController.agregarCheque(cheque);
    }


}
