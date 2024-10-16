package com.springTest.apiTest.services.exceptions;

public class DatabaseException extends  RuntimeException {
    public DatabaseException(String msg){
        super(msg);
    }
}
