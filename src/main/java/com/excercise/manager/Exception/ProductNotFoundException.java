package com.excercise.manager.Exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super("Could Not Find Employee "+ id);
    } 
}
