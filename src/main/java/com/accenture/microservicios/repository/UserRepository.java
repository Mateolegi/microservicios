package com.accenture.microservicios.repository;

import com.accenture.microservicios.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Obtiene un usuario por su nombre
     * @param name nombre
     * @return usuario
     */
    Optional<User> findByName(String name);
}
