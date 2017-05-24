package com.ws1001.controllers.forms.TakenKey;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by ramic on 24.05.2017..
 */
public class TakenKeyReturnKeyForm {
    @NotNull
    private Long reservationId;
    @NotNull
    private Date takenAt;
    @NotNull
    private Date returnedAt;


    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservation) {
        this.reservationId = reservation;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public Date getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }
}
