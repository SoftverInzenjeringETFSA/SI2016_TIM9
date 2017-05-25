package com.ws1001.controllers.forms.Reservation;


import com.ws1001.models.ScheduleBlock;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class ReservationCreateForm {
    @Size(min = 2, max = 255) @NotNull
    private String classroomName;

    @Size(min = 4, max = 255) @NotNull
    private String teacherUsername;

    private ScheduleBlock scheduleBlock;

    private LocalDateTime reservedAt;

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    @Min(1) @NotNull
    private byte duration;

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    public ScheduleBlock getScheduleBlock() {
        return scheduleBlock;
    }

    public void setScheduleBlock(ScheduleBlock scheduleBlock) {
        this.scheduleBlock = scheduleBlock;
    }

    public byte getDuration() {
        return duration;
    }

    public void setDuration(byte duration) {
        this.duration = duration;
    }
}
