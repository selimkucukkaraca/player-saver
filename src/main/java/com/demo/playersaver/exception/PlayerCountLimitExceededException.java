package com.demo.playersaver.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlayerCountLimitExceededException extends RuntimeException{

    public PlayerCountLimitExceededException(String message) {
        super(message);
    }
}
