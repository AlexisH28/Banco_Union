package model.builders;

import model.entities.Cheque;

public class ChequeBuilder {
    private int id;
    private String numeroCheque;
    private int idCuenta;
    private String beneficiario;
    private double monto;
    private String montoLetras;
    private String prioridad;
    private String firmaDigital;
    private String estado;
    private String razonRechazo;
    private String fechaEmision;
    private String fechaProceso;

    public ChequeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ChequeBuilder setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
        return this;
    }

    public ChequeBuilder setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
        return this;
    }

    public ChequeBuilder setBeneficiario(String beneficiario) {
        if (beneficiario == null || beneficiario.isEmpty()) {
            throw new IllegalArgumentException("El beneficiario no puede estar vacío.");
        }
        this.beneficiario = beneficiario;
        return this;
    }

    public ChequeBuilder setMonto(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0.");
        }
        this.monto = monto;
        return this;
    }

    public ChequeBuilder setMontoLetras(String montoLetras) {
        this.montoLetras = montoLetras;
        return this;
    }

    public ChequeBuilder setPrioridad(String prioridad) {
        if (!"Alta".equals(prioridad) && !"Media".equals(prioridad) && !"Baja".equals(prioridad)) {
            throw new IllegalArgumentException("Prioridad inválida.");
        }
        this.prioridad = prioridad;
        return this;
    }

    public ChequeBuilder setFirmaDigital(String firmaDigital) {
        this.firmaDigital = firmaDigital;
        return this;
    }

    public ChequeBuilder setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public ChequeBuilder setRazonRechazo(String razonRechazo) {
        this.razonRechazo = razonRechazo;
        return this;
    }

    public ChequeBuilder setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
        return this;
    }

    public ChequeBuilder setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
        return this;
    }

    public Cheque build() {
        if (beneficiario == null || monto <= 0 || prioridad == null) {
            throw new IllegalStateException("Faltan campos obligatorios para construir el cheque.");
        }
        return new Cheque(id, numeroCheque, idCuenta, beneficiario, monto, montoLetras, prioridad, firmaDigital, estado, razonRechazo, fechaEmision, fechaProceso);
    }
}
