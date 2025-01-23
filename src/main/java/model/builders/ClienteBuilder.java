package model.builders;

import model.entities.Cliente;

public class ClienteBuilder {
    private int id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private String estado;

    public ClienteBuilder setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0.");
        }
        this.id = id;
        return this;
    }

    public ClienteBuilder setIdentificacion(String identificacion) {
        if (identificacion == null || identificacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La identificación no puede estar vacía.");
        }
        this.identificacion = identificacion;
        return this;
    }

    public ClienteBuilder setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
        return this;
    }

    public ClienteBuilder setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        this.apellido = apellido;
        return this;
    }

    public ClienteBuilder setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ClienteBuilder setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ClienteBuilder setCorreo(String correo) {
        if (correo != null && !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe ser válido.");
        }
        this.correo = correo;
        return this;
    }

    public ClienteBuilder setEstado(String estado) {
        if (!"Activo".equalsIgnoreCase(estado) && !"Inactivo".equalsIgnoreCase(estado)) {
            throw new IllegalArgumentException("El estado debe ser 'Activo' o 'Inactivo'.");
        }
        this.estado = estado;
        return this;
    }

    public Cliente build() {
        if (identificacion == null || nombre == null || apellido == null || estado == null) {
            throw new IllegalStateException("Faltan campos obligatorios para construir el Cliente.");
        }
        return new Cliente(id, identificacion, nombre, apellido, direccion, telefono, correo, estado);
    }
}

