package com.D.DolceForno;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/d")
public class CookieController {
    private CookieService cookieService;

    public CookieController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @GetMapping("/verif")
    public String verify(){
        return "ok";
    }
    //Listar
    @GetMapping("/listar")
    public List<CookieModel> show(){
        return cookieService.show();
    }
    //Adicionar
    //Atualizar
    //Deletar
}
