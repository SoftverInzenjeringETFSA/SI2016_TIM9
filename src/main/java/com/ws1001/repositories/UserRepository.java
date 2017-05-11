package com.ws1001.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.ws1001.models.User;

//poceo sam pisati CRUDRepository i onda sam prosetao po ostalim projektima
//i vidio da vecina koristi ovaj (naslijedjen iz CRUDRepository-a)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String  username);
}