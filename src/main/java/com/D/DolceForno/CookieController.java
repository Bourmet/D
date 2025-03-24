package com.D.DolceForno;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/d")
public class CookieController {
    @GetMapping("/verif")
    public String verify(){
        return "ok";
    }
}
