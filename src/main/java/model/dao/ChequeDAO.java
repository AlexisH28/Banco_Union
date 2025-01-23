package model.dao;

import model.entities.Cheque;

import java.util.List;

public interface ChequeDAO extends GenericDAO<Cheque> {
    // Listar los cheques emitidos por un cliente.
    List<Cheque> findChequesByClienteId(int idCliente);

    // Emitir un nuevo cheque para un cliente.
    boolean emitirCheque(Cheque cheque);
}
