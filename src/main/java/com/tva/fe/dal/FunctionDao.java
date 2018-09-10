package com.tva.fe.dal;

import org.springframework.data.repository.CrudRepository;

import com.tva.fe.model.Function;

public interface FunctionDao extends CrudRepository<Function, Integer> {

}