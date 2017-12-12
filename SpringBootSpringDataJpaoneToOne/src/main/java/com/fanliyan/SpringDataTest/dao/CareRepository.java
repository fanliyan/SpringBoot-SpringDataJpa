package com.fanliyan.SpringDataTest.dao;

import com.fanliyan.SpringDataTest.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareRepository extends JpaRepository<Card, Long> {

    Card findByCardNumber(String name);
}
