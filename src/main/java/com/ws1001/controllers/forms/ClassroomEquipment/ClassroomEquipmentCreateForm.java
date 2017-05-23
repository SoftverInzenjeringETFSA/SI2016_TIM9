package com.ws1001.controllers.forms.ClassroomEquipment;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Dario on 5/22/2017.
 */
public class ClassroomEquipmentCreateForm {

    @NotNull
    @Min(1)
    private Long classroom;

    @NotNull
    @Min(1)
    private int equipmentTypeLabel;

    @NotNull
    @Size(min = 1, max = 255)
    private String equipmentTypeName;

    @NotNull
    @Min(1)
    private int quantity;

    public Long getClassroom() {
        return classroom;
    }

    public void setClassroom( Long classroom ) {
        this.classroom = classroom;
    }

    public int getEquipmentTypeLabel() {
        return equipmentTypeLabel;
    }

    public void setEquipmentTypeLabel( int equipmentTypeLabel ) {
        this.equipmentTypeLabel = equipmentTypeLabel;
    }

    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    public void setEquipmentTypeName( String equipmentTypeName ) {
        this.equipmentTypeName = equipmentTypeName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }
}
