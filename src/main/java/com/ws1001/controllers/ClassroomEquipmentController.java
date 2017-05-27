package com.ws1001.controllers;

import com.ws1001.controllers.forms.ClassroomEquipment.ClassroomEquipmentCreateForm;
import com.ws1001.models.Classroom;
import com.ws1001.models.ClassroomEquipment;
import com.ws1001.models.EquipmentType;
import com.ws1001.services.ClassroomEquipmentService;
import com.ws1001.services.ClassroomService;
import com.ws1001.services.EquipmentTypeService;
import com.ws1001.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Dario on 5/22/2017.
 */
@RestController
public class ClassroomEquipmentController extends BaseController<ClassroomEquipment, ClassroomEquipmentService> {

    private ClassroomService classroomService;
    private EquipmentTypeService equipmentTypeService;

    @Autowired
    public void setClassroomService (ClassroomService classroomService){this.classroomService = classroomService;}

    @Autowired
    public void setEquipmentTypeService (EquipmentTypeService equipmentTypeService) {this.equipmentTypeService = equipmentTypeService;}

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public ResponseEntity create( @RequestBody @Valid ClassroomEquipmentCreateForm newClassroomEquipment) {
        try{
            Classroom classroom = classroomService.get(newClassroomEquipment.getClassroomId());
            EquipmentType equipmentType = equipmentTypeService.get(newClassroomEquipment.getEquipmentTypeId());
            if(classroom == null || equipmentType == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong classroom or equipment type ID.");
            }

            return ResponseEntity.ok(service.save(new ClassroomEquipment(classroom, equipmentType, newClassroomEquipment.getQuantity())));

        } catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public ResponseEntity delete ( @PathVariable("id") Long id) {return super.delete(id);}
}