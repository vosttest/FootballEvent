package com.tva.fe.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tva.fe.model.Bet;
import com.tva.fe.model.Guess;

public interface GuessDao extends CrudRepository<Guess, Integer> {
	@Query("FROM Guess a WHERE a.id = :id AND a.phoneNo = :phoneNo")
	public Guess getBy(@Param("id") int id, @Param("phoneNo") String phoneNo);

	@Query("FROM Guess a WHERE a.id = :id")
	public Bet getById(@Param("id") int id);
}