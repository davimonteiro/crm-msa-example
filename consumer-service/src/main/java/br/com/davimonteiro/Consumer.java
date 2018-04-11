package br.com.davimonteiro;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
public class Consumer {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String address;
    private String email;

}
