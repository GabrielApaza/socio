package com.example.demo.controladores;


import com.example.demo.Entity.Departamento;
import com.example.demo.Services.DepartamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoControler {
    @Autowired
    private DepartamentoServicio departamentoServicio;

    @GetMapping
    public List<Departamento> getAll() {
        return departamentoServicio.getDepartamento();
    }
    @GetMapping("/{idDepartamento}")
    public Optional<Departamento> getByid(@PathVariable("idDepartamento") long idDepartamento) {
        return departamentoServicio.getDepartamento(idDepartamento);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Departamento departamento) {
        departamentoServicio.saveOrUpdate(departamento);
    }
}