package com.practo.practo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private long Id;

    private String name;

    private String disease;

    private int age;


}
