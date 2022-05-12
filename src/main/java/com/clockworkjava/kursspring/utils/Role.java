package com.clockworkjava.kursspring.utils;

import com.clockworkjava.kursspring.domain.PlayerInformation;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String role;

    public Role() {
    }

    public Role(String userName, String userRole) {
        this.username = userName;
        this.role = userRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
