package br.com.atitus.trabalhoCRUDG2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @GetMapping("/auth/signup")
    public void authSignup() {

    }

    @GetMapping("/auth/signin")
    public void authSignin() {

    }


}
