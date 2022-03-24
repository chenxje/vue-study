package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class User {

    private int id;

    private String userName;

    private String password;

    private String phoneNumber;

    private String email;

    private boolean enabled;

    private Date createDate;

    private Date modityDate;
}
