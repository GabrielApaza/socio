package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idDepartamento;

    @Column(name="nombreDepartamento", nullable=false, length = 12)
    private String nombreDepartamento;

    @Column(name="jerarquia", nullable=false, length = 12)
    private String jerarquia;

    @ManyToMany(fetch=FetchType.LAZY,cascade= CascadeType.MERGE)
   @JoinTable(
            name="departamento_usuario", joinColumns = @JoinColumn(name = "id_departamento", referencedColumnName = "idDepartamento"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario",referencedColumnName = "idUsuario"))
    private List<Usuario> usuarios ;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name="departamento_posiblecargo", joinColumns = @JoinColumn(name = "id_departamento", referencedColumnName = "idDepartamento"),
            inverseJoinColumns = @JoinColumn(name = "id_posiblecargo",referencedColumnName = "idPosibleCargo"))
    private List<PosibleCargo> posiblescargos;

}
