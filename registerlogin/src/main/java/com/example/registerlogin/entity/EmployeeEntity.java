package com.example.registerlogin.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "mt_user")
public class EmployeeEntity {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    UUID uuid = UUID.randomUUID();
    @Id
    private String id = String.valueOf(UUID.randomUUID());
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

//    public String getId() {
//        return id;
//    }

//    public void setId(Long id) {
//        this.id = String.valueOf(id);
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
