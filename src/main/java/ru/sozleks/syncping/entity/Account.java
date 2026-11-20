package ru.sozleks.syncping.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @OneToMany(mappedBy = "account_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Master> masters = new ArrayList<>();

    public Account() {}

    public Long getId() {return this.id;}
    public String getEmail() {return this.email;}
    public String getFullName() {return this.full_name;}

    public void setId(Long id) {this.id = id;}
    public void setEmail(String email) {this.email = email;}
    public void setFullName(String full_name) {this.full_name = full_name;}
}
