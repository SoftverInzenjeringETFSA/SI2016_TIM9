package com.ws1001.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.ws1001.models.User;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByUsernameContaining(String partOfUsername);
}