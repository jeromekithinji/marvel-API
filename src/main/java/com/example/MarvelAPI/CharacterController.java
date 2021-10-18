package com.example.MarvelAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/recipes")
public class CharacterController {

    @GetMapping("http://gateway.marvel.com/v1/public/comics?ts=1&apikey=89c9ab3aca2e0160d0feaae4b3527845&hash=21ad01e8bd5b7e4dfb8242b3c2bcc108")
    public String indexCharacters() {
        return ("Ok");
    }
}