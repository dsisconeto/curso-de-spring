package com.dsisconeto.learging.api.study;

import com.dsisconeto.learging.student.IStoreRequest;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

class StoreRequestDTO implements IStoreRequest {

    @NotNull
    @Length(max = 50)
    @NotEmpty
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
