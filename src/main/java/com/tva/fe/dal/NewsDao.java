package com.tva.fe.dal;

import org.springframework.data.repository.CrudRepository;

import com.tva.fe.model.News;

public interface NewsDao extends CrudRepository<News, Integer> {

}