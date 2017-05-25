package com.ws1001.services;

import com.ws1001.models.Reservation;
import com.ws1001.repositories.ReservationRepository;
import org.springframework.stereotype.Service;
import com.ws1001.services.exceptions.ServiceException;
import java.util.List;

@Service
public class ReservationService extends BaseService<Reservation, ReservationRepository> {
    public List<Reservation> findByUsername(String username) {
        return repository.findByTeacher(new UserService().getByUsername(username));
    }

    public List<Reservation> findByClassroom(String name) {
        return repository.findByClassroom(new ClassroomService().getByName(name));
    }

    public Reservation save(Reservation reservation) throws ServiceException {
        if (!reservationValid(reservation)) {
            throw new ServiceException("Invalid reservation time!");
        }

        Reservation conflict = findReservationConflict(reservation);

        if (conflict != null) {
            throw new ServiceException(String.format("User %s reserved that classroom for %d:00",
                    (conflict.getTeacher().getFirstName() + " " + conflict.getTeacher().getLastName()),
                    conflict.getReservedAt().getHour()));
        }

        if (!(teacherHasRightsToClassroom(reservation))) {
            throw new ServiceException("Teacher not allowed to use classroom!");
        }

        return super.save(reservation);
    }

    private boolean reservationValid(Reservation reservation) {
        int hour = reservation.getReservedAt().getHour();
        int duration = reservation.getDuration();

        return hour >= 7 && hour + duration <= 22;
    }

    private Reservation findReservationConflict(Reservation reservation) {
        int startHour = reservation.getReservedAt().getHour();
        byte duration = reservation.getDuration();

        List<Reservation> classroomReservations = this.findByClassroom(reservation.getClassroom().getName());

        for (Reservation classroomReservation : classroomReservations) {
            if (classroomReservation.getReservedAt().getDayOfYear() == reservation.getReservedAt().getDayOfYear() &&
                    classroomReservation.getReservedAt().getYear() == reservation.getReservedAt().getYear()) {
                int crStartHour = classroomReservation.getReservedAt().getHour();
                int crDuration = classroomReservation.getDuration();

                if (!(startHour + duration < crStartHour || crStartHour + crDuration < startHour)) {
                    return classroomReservation;
                }
            }
        }

        return null;
    }

    private boolean teacherHasRightsToClassroom(Reservation reservation) {
        // return new ClassroomService().availableTo(reservation.getClassroom(), reservation.getUser());
        return true; // TODO: Fix when (and if) method is implemented
    }
}
