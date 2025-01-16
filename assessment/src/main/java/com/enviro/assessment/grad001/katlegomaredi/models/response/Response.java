package com.enviro.assessment.grad001.katlegomaredi.models.response;

import com.enviro.assessment.grad001.katlegomaredi.models.entities.Category;

public class Response {
    private String message;

    public Response( String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
