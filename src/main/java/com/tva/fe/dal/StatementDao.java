package com.tva.fe.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tva.fe.model.Statement;

public interface StatementDao extends CrudRepository<Statement, Integer> {
	@Query("FROM Statement a WHERE a.id = :id")
	public Statement getBy(@Param("id") int id);

	@Query("SELECT id, name FROM Statement where parent_id IS NULL")
	public List<Statement> search();
}