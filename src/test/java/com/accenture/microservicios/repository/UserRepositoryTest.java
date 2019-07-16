package com.accenture.microservicios.repository;

import com.accenture.microservicios.entity.User;
import com.accenture.microservicios.entity.User.UserBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
@AutoConfigureDataMongo
public class UserRepositoryTest {

    @Autowired private UserRepository userRepository;


    /**
     * Consulta un usuario que no existe en el contexto de MongoDB.
     */
    @Test
    public void test_findByName_when_user_not_exists() {
        assertFalse(userRepository.findByName("Non existing user").isPresent());
    }


    /**
     * Consulta un usuario existente el en contexto de MongoDB.
     */
    @Test
    public void test_findByName_when_user_exists() {
        userRepository.save(new UserBuilder()
                .withName("Pepe Corrales")
                .withUserName("pepe.corrales")
                .build());
        assertTrue(userRepository.findByName("Pepe Corrales").isPresent());
    }

    /**
     * Obtiene todos los usuario y valida que la lista no sea nula.
     */
    @Test
    public void test_findAll_non_null() {
        List<User> users = userRepository.findAll();
        assertThat(users, is(notNullValue()));
    }
}