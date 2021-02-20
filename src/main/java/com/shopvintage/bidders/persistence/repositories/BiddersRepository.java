package com.shopvintage.bidders.persistence.repositories;

import com.shopvintage.bidders.persistence.entities.Bidder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiddersRepository extends JpaRepository<Bidder, Integer> {
}
