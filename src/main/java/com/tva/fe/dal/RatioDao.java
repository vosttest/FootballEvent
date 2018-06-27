package com.tva.fe.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tva.fe.model.Ratio;

public interface RatioDao extends CrudRepository<Ratio, Integer> {
	@Query("FROM Ratio a WHERE a.id = :id")
	public Ratio getBy(@Param("id") int id);

	@Query("FROM Ratio")
	public List<Ratio> search();
}