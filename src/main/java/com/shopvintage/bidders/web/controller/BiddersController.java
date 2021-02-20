package com.shopvintage.bidders.web.controller;

import com.shopvintage.bidders.persistence.entities.Bidder;
import com.shopvintage.bidders.persistence.repositories.BiddersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bidders")
public class BiddersController {

    private static final Logger LOGGER= LoggerFactory.getLogger(BiddersController.class);

    @Autowired
    private BiddersRepository biddersRepository;

    @Value("${spring.profiles.active}")
    private String activeProfile;
    @Value("${application.parameters.country}")
    private String country;

    @GetMapping
    public List<Bidder> findAll(){
        LOGGER.info("findAll");
        LOGGER.info(activeProfile);
        LOGGER.info(country);
        return this.biddersRepository.findAll();
    }

    @GetMapping("/{id}/{name}")
    public Bidder findById(@PathVariable("id") Integer id, @PathVariable("name") String name){
        System.out.println("name = " + name);
        return this.biddersRepository.findById(id).get();
    }

    @GetMapping("find")
    public Bidder find(@Param("id") Integer id, @Param("name") String name){
        System.out.println("name = " + name);
        return this.biddersRepository.findById(id).get();
    }

    @PostMapping
    public Bidder save(@RequestBody Bidder bidder){
        return this.biddersRepository.save(bidder);
    }

    @PatchMapping
    public Bidder update(@RequestBody Bidder bidder){
        return this.biddersRepository.save(bidder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
         this.biddersRepository.deleteById(id);
    }

}
