package com.example.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Customers")
public class Customer implements Cloneable{
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String address, Province province) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.province = province;
    }
}
