package com.ws1001.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ws1001.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
