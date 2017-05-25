package com.ws1001.controllers;

import com.ws1001.controllers.forms.EquipmentType.EquipmentTypeCreateForm;
import com.ws1001.models.EquipmentType;
import com.ws1001.services.EquipmentTypeService;
import com.ws1001.services.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Dario on 5/22/2017.
 */
@RestController
public class EquipmentTypeController extends BaseController<EquipmentType, EquipmentTypeService> {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public ResponseEntity create( @RequestBody @Valid EquipmentTypeCreateForm newEquipmentType){
        try{
            EquipmentType equipmentType = new EquipmentType(newEquipmentType.getLabel(), newEquipmentType.getName());
            equipmentType = service.save(equipmentType);
            return ResponseEntity.ok(equipmentType);
        } catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public ResponseEntity delete ( @PathVariable("id") Long id ) { return super.delete(id); }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public List<EquipmentType> searchByName( @PathVariable("name") String name){
        return (List<EquipmentType>) service.searchByName(name);
    }
}
