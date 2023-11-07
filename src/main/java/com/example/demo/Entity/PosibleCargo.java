package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name="posiblescargos")
public class PosibleCargo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idPosibleCargo;
    private String nombrePosibleCargo;

}