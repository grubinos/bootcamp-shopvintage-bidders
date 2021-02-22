package com.shopvintage.bidders.web.controller;

import com.shopvintage.bidders.persistence.entities.Bidder;
import com.shopvintage.bidders.persistence.repositories.BiddersRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Bidder> findAll() {
        return this.biddersRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bidder> findById(@PathVariable("id") Integer id) {
        var bidder = this.biddersRepository.findById(id).get();
        return ResponseEntity.ok(bidder);
    }

    @GetMapping("find")
    public Bidder find(@Param("id") Integer id, @Param("name") String name) {
        return this.biddersRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Bidder> save(@RequestBody Bidder bidder) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.biddersRepository.save(bidder));
    }

    @PatchMapping
    public Bidder update(@RequestBody Bidder bidder) {
        return this.biddersRepository.save(bidder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        this.biddersRepository.deleteById(id);
    }

}
