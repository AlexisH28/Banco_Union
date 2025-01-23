package model.dao.impl;

import model.builders.ChequeBuilder;
import model.dao.ChequeDAO;
import model.database.ConexionDB;
import model.entities.Cheque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChequeDAOImpl implements ChequeDAO {
    private Connection connection;

    public ChequeDAOImpl() {
        try {
            this.connection = ConexionDB.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cheque findById(int id) {
        // Implementación opcional si se requiere.
        return null;
    }

    @Override
    public List<Cheque> findAll() {
        // Implementación opcional si se requiere.
        return null;
    }

    @Override
    public List<Cheque> findByCondition(String condition) {
        // Implementación genérica para condiciones personalizadas.
        return null;
    }

    @Override
    public List<Cheque> findChequesByClienteId(int idCliente) {
        String sql = "SELECT c.* FROM cheques c INNER JOIN cuentas cu ON c.id_cuenta = cu.id WHERE cu.id_cliente = ?";
        List<Cheque> cheques = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cheque cheque = new ChequeBuilder()
                        .setId(rs.getInt("id"))
                        .setNumeroCheque(rs.getString("numero_cheque"))
                        .setIdCuenta(rs.getInt("id_cuenta"))
                        .setBeneficiario(rs.getString("beneficiario"))
                        .setMonto(rs.getDouble("monto"))
                        .setMontoLetras(rs.getString("monto_letras"))
                        .setPrioridad(rs.getString("prioridad"))
                        .setFirmaDigital(rs.getString("firma_digital"))
                        .setEstado(rs.getString("estado"))
                        .setRazonRechazo(rs.getString("razon_rechazo"))
                        .setFechaEmision(rs.getString("fecha_emision"))
                        .setFechaProceso(rs.getString("fecha_proceso"))
                        .build();
                cheques.add(cheque);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cheques;
    }

    @Override
    public boolean emitirCheque(Cheque cheque) {
        String sql = "INSERT INTO cheques (numero_cheque, id_cuenta, beneficiario, monto, monto_letras, prioridad, firma_digital, estado, fecha_emision) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, cheque.getNumeroCheque());
            ps.setInt(2, cheque.getIdCuenta());
            ps.setString(3, cheque.getBeneficiario());
            ps.setDouble(4, cheque.getMonto());
            ps.setString(5, cheque.getMontoLetras());
            ps.setString(6, cheque.getPrioridad());
            ps.setString(7, cheque.getFirmaDigital());
            ps.setString(8, cheque.getEstado());
            ps.setString(9, cheque.getFechaEmision());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
