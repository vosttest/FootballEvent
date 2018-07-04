package com.tva.fe.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tva.fe.model.News;

public interface NewsDao extends CrudRepository<News, Integer> {
	@Query("FROM News a WHERE a.id = :id")
	public News getBy(@Param("id") int id);

	@Query("FROM News")
	public List<News> search();
}