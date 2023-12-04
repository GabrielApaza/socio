package com.example.demo.Services.Impl;

import com.example.demo.Entity.Socio;
import com.example.demo.Repository.SocioRepository;
import com.example.demo.Services.ISocioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class SocioServicioImpl implements ISocioServicio {
    @Autowired
    SocioRepository socioReposity;

   @Override
    public Page<Socio> encuentrePaginaFinal(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return this.socioReposity.findAll(pageable);
    }
}
