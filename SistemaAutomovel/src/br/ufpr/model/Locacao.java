/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.model;

import java.util.Date;

/**
 *
 * @author Giovanni
 */
public class Locacao {
    
    private Integer idVeiculo;
    private Cliente cliente;
    private Integer dias;
    private Date dataInicio;
    private Double valor;

    public Locacao(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    
    public Locacao(Integer idVeiculo, Cliente cliente, Integer dias, Date dataInicio, Double valor) {
        this.idVeiculo = idVeiculo;
        this.cliente = cliente;
        this.dias = dias;
        this.dataInicio = dataInicio;
        this.valor = valor;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Integer getIdVeiculo() {
        return idVeiculo;
    }
    
    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }    
}
