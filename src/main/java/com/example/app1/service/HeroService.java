package com.example.app1.service;

import com.example.app1.model.Hero;
import com.example.app1.repo.HeroRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    private final HeroRepo hRepo;

    public HeroService(HeroRepo hRepo) {
        this.hRepo = hRepo;
    }

    public Hero getHero(Integer id){
        return hRepo.findById(id).get();
    }

    public List<Hero> getAllHero(){
        List<Hero> hlist=new ArrayList<>();
        hRepo.findAll().forEach(hlist::add);
        return hlist;
    }

    public Hero addHero(Hero h){
        h.setId(null);
        return hRepo.save(h);
    }

    public Hero updateHero(Hero h){
        Optional<Hero> hDbOpt = hRepo.findById(h.getId());
        if(hDbOpt.isPresent()){
            Hero hDb=hDbOpt.get();
            hDb.setColor(h.getColor());
            hDb.setName(h.getName());
            hDb.setPower(hDb.getPower());
            return hRepo.save(hDb);
        }
        return null;
    }
}

