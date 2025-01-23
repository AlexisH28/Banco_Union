package model.dao;

import java.util.List;

public interface GenericDAO<T> {
    // Buscar un registro por su ID
    T findById(int id);

    // Listar todos los registros.
    List<T> findAll();

    // Buscar registros con condiciones personalizadas.
    List<T> findByCondition(String condition);
}