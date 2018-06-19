package com.tva.fe.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tva.fe.model.Team;

public interface TeamDao extends CrudRepository<Team, Integer> {
	@Query("FROM Team")
	public List<Team> search();
}