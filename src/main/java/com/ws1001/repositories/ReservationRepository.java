package com.ws1001.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.ws1001.models.Reservation;

import java.util.List;

public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long> {
    List<Reservation> findByUsername(String username);
    List<Reservation> findByClassroom(String name);
}