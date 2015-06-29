package com.ninja_squad.geektic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Anthony on 29/06/15.
 * Project : geektic2014
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyException extends RuntimeException {
    public MyException(String message){
        super(message);
    }
}
