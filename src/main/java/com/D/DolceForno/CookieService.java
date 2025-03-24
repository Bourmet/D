package com.D.DolceForno;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookieService {
    private CookieRepository cookieRepository;

    public CookieService(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }
    //listar
    public List<CookieModel> show(){
        return cookieRepository.findAll();
    }
    //Adicionar
    //Atualizar
    //Deletar
}
