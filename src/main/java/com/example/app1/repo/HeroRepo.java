package com.example.app1.repo;

import com.example.app1.model.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepo extends CrudRepository<Hero,Integer> {
}
