package com.example.demo.controladores;

import com.example.demo.Entity.Socio;
import com.example.demo.Enum.TipoSocio;
import com.example.demo.Services.SocioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/socios")
public class SocioControler {
    @Autowired
    public SocioServicio socioServicio;

    @GetMapping("/")
    public List<Socio> getAll() {
        return socioServicio.getSocio();
    }

    @GetMapping("/{idSocio}")
    public Optional<Socio> getByid(@PathVariable("idSocio") long idSocio) {

        return socioServicio.getSocio(idSocio);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Socio socio) {

        socioServicio.saveOrUpdate(socio);
    }
    @GetMapping("/nombreSocio")
    public List<Socio> getByid(@RequestParam String nombreSocio) {

        return socioServicio.getnombreSocio(nombreSocio);
     }

    @GetMapping("/fechaAlta")
    public List<Socio> getByidfechaAlta(@RequestParam String fechaAlta) {
       /* String fechaAlta = "yyyy-MM-dd";
        LocalDate date = LocalDate.parse(fechaAlta, DateTimeFormatter.BASIC_ISO_DATE);
        return socioServicio.getfechaAlta(fechaAlta);**/
    }

    @GetMapping("/tipoSocio")
    public List<Socio> getByidytipoSocio(@RequestParam String tipoSocio) {

        return socioServicio.gettipoSocio(tipoSocio);}
}