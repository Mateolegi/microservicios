package com.accenture.microservicios.controller;

import com.accenture.microservicios.entity.User;

import java.util.List;

public interface UserController {

    /**
     * Obtiene todos los usuarios
     * @return usuarios
     */
    List<User> findAll();

    /**
     * Obtiene un usuario por su ID
     * @param id id del usuario
     * @return usuario
     */
    User findById(String id);

    /**
     * Obtiene un usuario por su nombre
     * @param name nombre del usuario
     * @return usuario
     */
    User findByName(String name);

    /**
     * Almacena un usuario
     * @param user usuario
     * @return usuario almacenado
     */
    User save(User user);

    /**
     * Actualiza un usuario
     * @param user usuario
     * @return usuario
     */
    User update(User user);

    /**
     * Elimina un usuario
     * @param id id del usuario
     */
    void delete(String id);
}
