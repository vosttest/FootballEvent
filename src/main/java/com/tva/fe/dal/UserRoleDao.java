package com.tva.fe.dal;

import org.springframework.data.repository.CrudRepository;

import com.tva.fe.model.UserRole;

public interface UserRoleDao extends CrudRepository<UserRole, Integer> {

}