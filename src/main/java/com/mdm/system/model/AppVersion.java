package com.mdm.system.model;

import jakarta.persistence.*;
//import lombok.Data;

@Entity
//@Data
public class AppVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String version;
    private boolean mandatory;
}