package br.com.Sys.Cad.dto;

import br.com.Sys.Cad.Entities.Secador01;

import java.io.Serializable;

public class Secador01DTO  implements Serializable {
    private static final long serialVersiionUID = 1L;

    private Long id;
    private String umidade;
    private String perca;
    private String data;

    public Secador01DTO(Object x){

    }

    public Secador01DTO(Long id, String umidade, String perca, String data) {
        this.id = id;
        this.umidade = umidade;
        this.perca = perca;
        this.data = data;
    }

    public Secador01DTO (Secador01 entity){
        this.id = entity.getId();
        this.umidade = entity.getUmidade();
        this.perca = entity.getPerca();
        this.data = entity.getData();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public String getPerca() {
        return perca;
    }

    public void setPerca(String perca) {
        this.perca = perca;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
