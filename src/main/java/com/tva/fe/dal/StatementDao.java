package com.tva.fe.dal;

import org.springframework.data.repository.CrudRepository;

import com.tva.fe.model.Statement;

public interface StatementDao extends CrudRepository<Statement, Integer> {

}