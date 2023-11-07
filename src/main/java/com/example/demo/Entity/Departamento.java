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

    public Departamento() {
    }

    public Departamento(long idDepartamento, String nombreDepartamento, String jerarquia, List<Usuario> usuarios,
                        List<PosibleCargo> posiblescargos) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.jerarquia = jerarquia;
        this.usuarios = usuarios;
        this.posiblescargos = posiblescargos;
    }

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<PosibleCargo> getPosiblescargos() {
        return posiblescargos;
    }

    public void setPosiblescargos(List<PosibleCargo> posiblescargos) {
        this.posiblescargos = posiblescargos;
    }
}

