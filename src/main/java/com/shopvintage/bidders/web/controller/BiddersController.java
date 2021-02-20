package com.shopvintage.bidders.web.controller;

import com.shopvintage.bidders.persistence.entities.Bidder;
import com.shopvintage.bidders.persistence.repositories.BiddersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bidders")
public class BiddersController {

    @Autowired
    private BiddersRepository biddersRepository;

//    public BiddersController(BiddersRepository biddersRepository){
//        this.biddersRepository=biddersRepository;
//    }

    @GetMapping
    public List<Bidder> findAll(){
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
