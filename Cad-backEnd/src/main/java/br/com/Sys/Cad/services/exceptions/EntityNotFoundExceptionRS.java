package br.com.Sys.Cad.services.exceptions;

public class EntityNotFoundExceptionRS extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntityNotFoundExceptionRS(String msg){
        super(msg);
    }

}
