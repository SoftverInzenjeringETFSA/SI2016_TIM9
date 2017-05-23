package com.ws1001.controllers.forms.AccessGrant;

import javax.validation.constraints.NotNull;

/**
 * Created by amina on 22.05.2017..
 */
public class AccessGrantCreateForm {

    private Long id;

    @NotNull
    private Long classroom_id;

    @NotNull
    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public Long getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(Long classroom_id) {
        this.classroom_id = classroom_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

}
