package com.ws1001.repositories;

import com.ws1001.models.Classroom;
import com.ws1001.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface ClassroomRepository extends PagingAndSortingRepository<Classroom, Long> {
    Classroom findByName(String name);
}