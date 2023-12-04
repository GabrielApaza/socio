package com.example.demo.Services;

import com.example.demo.Entity.Socio;
import org.springframework.data.domain.Page;



public interface ISocioServicio {
    Page<Socio> encuentrePaginaFinal(int pageNo, int pageSize);
}
