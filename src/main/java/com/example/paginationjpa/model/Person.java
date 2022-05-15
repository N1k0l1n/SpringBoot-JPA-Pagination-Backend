package com.example.paginationjpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Person {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private Integer Id;

    private String firsName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Person(String firsName, String lastName, String phoneNumber, String email, Address address) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
