package com.example.dayFlow.exception;

public class BadRequestException extends RuntimeException
{
    public BadRequestException(String ex)
    {
        super(ex);
    }
}
