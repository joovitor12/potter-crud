package com.pottercrudenhanced.exceptions;


import lombok.Getter;


@Getter
public class WizardException extends RuntimeException {
    private String message;

    public WizardException(String message){
        this.message = message;
    }

}
