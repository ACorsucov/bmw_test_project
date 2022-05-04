package com.testproject.testproject.persitence.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "test_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String website;

    @Column
    private String street;
    @Column
    private String suite;
    @Column
    private String city;
    @Column
    private String zipCode;

    @Column
    private String lat;
    @Column
    private String lng;

    @Column
    private String companyName;
    @Column
    private String companyCatchPhrase;
    @Column
    private String companyBs;
}

