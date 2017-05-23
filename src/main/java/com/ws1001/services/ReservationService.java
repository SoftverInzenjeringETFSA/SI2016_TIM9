package com.ws1001.services;

import com.ws1001.models.Reservation;
import com.ws1001.repositories.ReservationRepository;

import java.util.Date;
import java.util.List;

public class ReservationService extends BaseService<Reservation, ReservationRepository> {
    public List<Reservation> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public List<Reservation> findByReservedAt(Date date) {
        return repository.findByReservedAt(date);
    }

    public List<Reservation> findByClassroom(String name) {
        return repository.findByClassroom(name);
    }
}
