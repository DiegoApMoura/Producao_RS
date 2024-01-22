package br.com.Sys.Cad.services.exceptions;

public class DatabaseExceptionRS extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DatabaseExceptionRS(String msg){
        super(msg);
    }

}
