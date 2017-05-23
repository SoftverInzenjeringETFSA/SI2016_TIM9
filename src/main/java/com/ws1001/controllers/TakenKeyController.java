package com.ws1001.controllers;

import com.ws1001.controllers.forms.TakenKey.TakenKeyTakeForm;
import com.ws1001.models.Reservation;
import com.ws1001.models.TakenKey;
import com.ws1001.models.User;
import com.ws1001.services.ReservationService;
import com.ws1001.services.TakenKeyService;
import com.ws1001.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by ramic on 22.05.2017..
 */
@RestController
public class TakenKeyController extends BaseController<TakenKey, TakenKeyService> {

    protected ReservationService reservationService;

    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public ResponseEntity take(@RequestBody @Valid TakenKeyTakeForm newTakenKey)
    {
        try {
            Long reservationId = newTakenKey.getReservationId();
            Reservation currentResrevation = null;
            if(reservationId != null) {
                currentResrevation = reservationService.get(reservationId);
                if(currentResrevation == null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not a reservation");
                }
            }

            TakenKey takenKey = new TakenKey(currentResrevation,
            newTakenKey.getTakenAt(),
            newTakenKey.getReturnedAt());

            takenKey = service.save(takenKey);
            return ResponseEntity.ok(takenKey);
        } catch(ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
