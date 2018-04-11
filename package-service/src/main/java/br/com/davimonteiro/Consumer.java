package br.com.davimonteiro;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Data
public class Consumer {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

}
