package view;

import model.builders.ChequeBuilder;
import model.factories.ConcreteDAOFactory;
import model.factories.DAOFactory;
import model.dao.ChequeDAO;
import model.entities.Cheque;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFactory daoFactory = new ConcreteDAOFactory();
        ChequeDAO chequeDAO = daoFactory.getChequeDAO();

        int idCliente = 1; // Cambiar por el ID del cliente deseado

        System.out.println("Cheques emitidos por el cliente con ID: " + idCliente);
        /*List<Cheque> cheques = chequeDAO.findChequesByClienteId(idCliente);
        for (Cheque cheque : cheques) {
            System.out.println("Cheque: " + cheque.getNumeroCheque() + ", Monto: " + cheque.getMonto() + ", Fecha: " + cheque.getFechaEmision());
        }*/

        chequeDAO.findChequesByClienteId(idCliente)
                .forEach(cheque -> System.out.println("Cheque: " + cheque.getNumeroCheque()
                        + ", Monto: " + cheque.getMonto()
                        + ", Fecha: " + cheque.getFechaEmision()));


        System.out.println("\nEmitir nuevo cheque:");
        Cheque nuevoCheque = new ChequeBuilder()
                .setNumeroCheque("CHQ-12345")
                .setIdCuenta(1) // Cambiar por la cuenta del cliente
                .setBeneficiario("Paquita la del barrio")
                .setMonto(500.00)
                .setMontoLetras("Quinientos")
                .setPrioridad("Alta")
                .setFirmaDigital("FirmaDigital123")
                .setEstado("Pendiente")
                .setFechaEmision("2025-01-23")
                .build();

        boolean resultado = chequeDAO.emitirCheque(nuevoCheque);
        if (resultado) {
            System.out.println("Cheque emitido correctamente: " + nuevoCheque.getBeneficiario() + ", Monto: " + nuevoCheque.getMonto());
        } else {
            System.out.println("Error al emitir el cheque.");
        }
    }
}
