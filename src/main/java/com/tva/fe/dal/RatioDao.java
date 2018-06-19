package com.tva.fe.dal;

import org.springframework.data.repository.CrudRepository;

import com.tva.fe.model.Ratio;

public interface RatioDao extends CrudRepository<Ratio, Integer> {

}