package com.example.demo.controladores;

import com.example.demo.Entity.Domicilio;
import com.example.demo.Services.DomicilioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/domicilios")
public class DomicilioControler {
    @Autowired
    public DomicilioServicio domicilioServicio;

    @GetMapping("/")
    public List<Domicilio> getAll() {

        return domicilioServicio.getDomicilio();
    }
    @GetMapping("/idDomicilio")
    public Optional<Domicilio> getByid(@PathVariable("idDomicilio") Long idDomicilio) {

        return domicilioServicio.getDomicilio(idDomicilio);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Domicilio domicilio) {

        domicilioServicio.saveOrUpdate(domicilio);
    }

}
