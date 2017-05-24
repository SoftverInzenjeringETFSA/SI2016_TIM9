package com.ws1001.controllers;

import com.ws1001.controllers.forms.AccessGrant.AccessGrantCreateForm;
import com.ws1001.models.AccessGrant;
import com.ws1001.models.Classroom;
import com.ws1001.models.User;
import com.ws1001.services.AccessGrantService;
import com.ws1001.services.ClassroomService;
import com.ws1001.services.UserService;
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
 * Created by amina on 22.05.2017..
 */

@RestController
public class AccessGrantController extends BaseController<AccessGrant, AccessGrantService>{

    private ClassroomService classroomService;
    private UserService userService;

    @Autowired
    public void setClassroomService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

   // @PreAuthorize("hasRole('ROLE_OPERATOR')")
    @ResponseBody
    public ResponseEntity create(@RequestBody @Valid AccessGrantCreateForm newAccessGrant) {
        try {

           Classroom classroom = classroomService.get(newAccessGrant.getClassroom_id());
           User teacher = userService.get(newAccessGrant.getUser_id());

            AccessGrant accessGrant = new AccessGrant();
            accessGrant.setClassroom(classroom);
            accessGrant.setTeacher(teacher);

            accessGrant = service.save(accessGrant);
            return ResponseEntity.ok(accessGrant);

        } catch(ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ResponseBody
    public ResponseEntity getAllByClassroomId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getAllByClassroomId(id));
    }

    @ResponseBody
    public ResponseEntity getAllByTeacherId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getAllByTeacherId(id));
    }


}
