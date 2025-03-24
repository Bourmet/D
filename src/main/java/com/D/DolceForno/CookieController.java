package com.D.DolceForno;

import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/adicionar")
    public CookieModel add(@RequestBody CookieModel cookieModel){
        return cookieService.add(cookieModel);
    }
    //Deletar
    @DeleteMapping("/deletar/{id}")
    public void del(@PathVariable Long id){
        cookieService.del(id);
    }
    //Atualizar
    @PatchMapping("/atualizar/{id}")
    public CookieModel pchange(@PathVariable Long id, @RequestBody CookieModel cookieModel){
        return cookieService.pchange(id, cookieModel);
    }

}
