package com.ws1001.controllers;

import com.ws1001.controllers.forms.Reservation.ReservationCreateForm;
import com.ws1001.models.Classroom;
import com.ws1001.models.Reservation;
import com.ws1001.models.ScheduleBlock;
import com.ws1001.models.User;
import com.ws1001.services.ClassroomService;
import com.ws1001.services.ReservationService;
import com.ws1001.services.UserService;
import com.ws1001.services.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.time.LocalDateTime;


public class ReservationController extends BaseController<Reservation, ReservationService> {
    @ResponseBody
    @PreAuthorize("HAS_ROLE('ROLE_OPERATOR')")
    public ResponseEntity create(@RequestBody @Valid ReservationCreateForm newReservation) {
        try {
            Classroom classroom = new ClassroomService().getByName(newReservation.getClassroomName());
            User user = new UserService().getByUsername(newReservation.getTeacherUsername());
            ScheduleBlock scheduleBlock = null; // Until we can figure out what it does
            LocalDateTime reservedAt = newReservation.getReservedAt(); // Gets current day
            byte duration = newReservation.getDuration();

            Reservation reservation = new Reservation(classroom, user, scheduleBlock, reservedAt, duration);
            reservation = service.save(reservation);

            return ResponseEntity.ok(reservation);
        } catch(ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ResponseBody
    @PreAuthorize("HAS_ROLE('ROLE_OPERATOR')")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
