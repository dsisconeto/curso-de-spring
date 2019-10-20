package com.dsisconeto.learging.api.study;

import com.dsisconeto.learging.student.IUpdateRequest;

public class UpdateRequest extends StoreRequestDTO implements IUpdateRequest {


    private int id;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

}