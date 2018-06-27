package com.tva.fe.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tva.fe.model.Team;

public interface TeamDao extends CrudRepository<Team, Integer> {
	@Query("FROM Team a WHERE a.id = :id")
	public Team getBy(@Param("id") int id);

	@Query("FROM Team")
	public List<Team> search();
}