package br.com.Sys.Cad.Entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "tb_Secador01")
public class Secador01 implements Serializable {
    private static final long serialVersiionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String umidade;
    private String perca;
    private String data;

    public Secador01(){

    }

    public Secador01(Long id, String umidade, String perca, String data) {
        this.id = id;
        this.umidade = umidade;
        this.perca = perca;
        this.data = data;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secador01 secador01 = (Secador01) o;
        return Objects.equals(id, secador01.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
