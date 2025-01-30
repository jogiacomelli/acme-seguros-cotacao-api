package br.com.acme.seguros.cotacao.api.core.domain;

import lombok.Data;

@Data
public class Customer {
    private String documentNumber;
    private String name;
    private String type;
    private String gender;
    private String dateOfBirth;
    private String email;
    private Long phoneNumber;
}