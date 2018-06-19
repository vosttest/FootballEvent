package com.tva.fe.dal;

import org.springframework.data.repository.CrudRepository;

import com.tva.fe.model.Bet;

public interface BetDao extends CrudRepository<Bet, Integer> {

}