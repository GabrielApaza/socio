/*package com.example.demo.controladores;

import com.example.demo.Entity.Socio;
import com.example.demo.Services.SocioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

@RequestMapping("/api/v1/socios")
public class SocioControler {
    @Autowired
    public SocioServicio socioServicio;

    @GetMapping
    public List<Socio> getAll() {
        return socioServicio.getSocios();
    }

    @GetMapping("/{idSocio}")
    public Optional<Socio> getByid(@PathVariable("idSocio") long idSocio) {
        return socioServicio.getSocio(idSocio);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Socio socio) {
        socioServicio.saveOrUpdate(socio);
    }
}**/