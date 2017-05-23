package com.ws1001.services;

import com.ws1001.models.Reservation;
import com.ws1001.repositories.ReservationRepository;
import com.ws1001.services.exceptions.ServiceException;

import java.util.List;

public class ReservationService extends BaseService<Reservation, ReservationRepository> {
    public List<Reservation> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public List<Reservation> findByClassroom(String name) {
        return repository.findByClassroom(name);
    }

    public Reservation save(Reservation reservation) throws ServiceException {
        if (reservationValid(reservation)) {
            return super.save(reservation);
        } else {
            throw new ServiceException("Reservation not available!");
        }
    }

    private boolean reservationValid(Reservation reservation) {
        int hour = reservation.getReservedAt().getHour();
        int duration = reservation.getDuration();

        return hour >= 7 && hour + duration <= 22 && reservationAvailable(reservation);
    }

    private boolean reservationAvailable(Reservation reservation) {
        int startHour = reservation.getReservedAt().getHour();
        byte duration = reservation.getDuration();

        List<Reservation> classroomReservations = this.findByClassroom(reservation.getClassroom().getName());

        for (Reservation classroomReservation : classroomReservations) {
            if (classroomReservation.getReservedAt().getDayOfYear() == reservation.getReservedAt().getDayOfYear() &&
                    classroomReservation.getReservedAt().getYear() == reservation.getReservedAt().getYear()) {
                int crStartHour = classroomReservation.getReservedAt().getHour();
                int crDuration = classroomReservation.getDuration();

                if (!(startHour + duration < crStartHour || crStartHour + crDuration < startHour)) {
                    return false;
                }
            }
        }

        return true;
    }
}
