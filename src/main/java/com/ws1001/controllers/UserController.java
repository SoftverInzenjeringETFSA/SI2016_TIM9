package com.ws1001.controllers;

import com.ws1001.controllers.forms.User.UserCreateForm;
import com.ws1001.models.User;
import com.ws1001.services.UserService;
import com.ws1001.services.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController extends BaseController<User, UserService> {

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

    @ResponseBody
    public ResponseEntity filterByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(service.getByPartOfUsername(username));
    }
}