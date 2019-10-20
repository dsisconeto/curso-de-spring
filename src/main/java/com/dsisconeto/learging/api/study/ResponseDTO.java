package com.dsisconeto.learging.api.study;

import com.dsisconeto.learging.student.Student;

import java.time.LocalDateTime;

class ResponseDTO {

    private int id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    ResponseDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.createdAt = student.getCreatedAt();
        this.updatedAt = student.getUpdatedAt();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
