package br.com.Sys.Cad.services.exceptions;

public class DataBaseNotFoundExceptionRS extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DataBaseNotFoundExceptionRS(String msg){
        super(msg);
    }

}
