package com.tva.fe.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tva.fe.model.Bet;

public interface BetDao extends CrudRepository<Bet, Integer> {
	@Query("FROM Bet a WHERE a.id = :id AND a.userId = :userId")
	public Bet getBy(@Param("id") int id, @Param("userId") int userId);

	@Query("FROM Bet a WHERE a.id = :id")
	public Bet getById(@Param("id") int id);
}