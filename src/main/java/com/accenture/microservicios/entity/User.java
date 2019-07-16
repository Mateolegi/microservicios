package com.accenture.microservicios.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User extends Person {

    @Id
    private String id;
    private String name;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static class UserBuilder {
        private final User user;

        public UserBuilder() {
            user = new User();
        }
        public UserBuilder withId(String id) {
            user.id = id;
            return this;
        }
        public UserBuilder withName(String name) {
            user.name = name;
            return this;
        }
        public UserBuilder withUserName(String userName) {
            user.userName = userName;
            return this;
        }
        public User build() {
            return user;
        }
    }
}
