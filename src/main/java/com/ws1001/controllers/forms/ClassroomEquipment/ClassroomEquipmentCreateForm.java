package com.ws1001.controllers.forms.ClassroomEquipment;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Dario on 5/22/2017.
 */
public class ClassroomEquipmentCreateForm {

    @NotNull
    @Min(1)
    private Long classroom;

    @NotNull
    @Min(1)
    private Long equipmentType;

    @NotNull
    @Min(1)
    private int quantity;

    public Long getClassroom() {
        return classroom;
    }

    public void setClassroom( Long classroom ) {
        this.classroom = classroom;
    }

    public Long getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType( Long equipmentType ) {
        this.equipmentType = equipmentType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }




}
