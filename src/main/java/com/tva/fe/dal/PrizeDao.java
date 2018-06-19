package com.tva.fe.dal;

import org.springframework.data.repository.CrudRepository;

import com.tva.fe.model.Prize;

public interface PrizeDao extends CrudRepository<Prize, Integer> {

}