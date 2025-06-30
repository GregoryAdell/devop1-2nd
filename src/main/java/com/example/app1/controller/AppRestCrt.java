package com.example.app1.controller;

import com.example.app1.model.Hero;
import com.example.app1.service.HeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1")
public class AppRestCrt {
    private final HeroService hService;

    public AppRestCrt(HeroService hService) {
        this.hService = hService;
    }

    @GetMapping("/heros")
    public List<Hero> getAllHero(){
            return hService.getAllHero();
    }

    @GetMapping("/hero/{mid}")
    public Hero getHero(@PathVariable String mid){
        return hService.getHero(Integer.valueOf(mid));
    }

    @PostMapping("/hero")
    public Hero addHero(@RequestBody Hero h){
        return hService.addHero(h);
    }

    @PutMapping("/hero")
    public Hero updateHero(@RequestBody Hero h){
        return hService.updateHero(h);
    }
}
