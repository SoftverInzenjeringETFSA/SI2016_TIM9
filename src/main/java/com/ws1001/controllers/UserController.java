package com.ws1001.controllers;

import com.ws1001.controllers.forms.User.UserCreateForm;
import com.ws1001.models.User;
import com.ws1001.services.UserService;
import com.ws1001.services.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController extends BaseController<User, UserService> {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public ResponseEntity create(@RequestBody @Valid UserCreateForm newUser) {
        try {
            User user = new User(newUser.getFirstName(),
                    newUser.getLastName(),
                    newUser.getUsername(),
                    newUser.getPassword(),
                    User.UserType.values()[newUser.getType()]);

            user = service.save(user);
            return ResponseEntity.ok(user);
        } catch(ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @ResponseBody
    public ResponseEntity filter(@PathVariable("term") String term) {
        return ResponseEntity.ok(service.filter(term));
    }

    @ResponseBody
    public ResponseEntity exists(@PathVariable("username") String username) {
        Boolean userExists = service.getByUsername(username) != null;
        if(userExists)
            return ResponseEntity.badRequest().body(true);

        return ResponseEntity.ok(false);
    }
}