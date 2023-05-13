package com.aninfo.model;

import javax.persistence.*;
@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;
    private Long cbu;
    private Double valor;

    private String tipoTransaccion;

    public Transaccion() {
    }

    public void Transaccion(Double valor) {
        this.valor = valor;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Double getValor(){
        return  valor;
    }

    public void setValor(Double nuevoValor){
        valor = nuevoValor;
    }

    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }

    public String getTipoTransaccion(){
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String unTipoTransaccion){
        tipoTransaccion = unTipoTransaccion;
    }


}
