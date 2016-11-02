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
    
//    private Cliente cliente;
//    private Veiculo veiculo;
    private Integer dias;
    private Date dataInicio;
    private Double valor;
    
//    public Locacao(Cliente cliente, Veiculo veiculo, Integer dias, Date dataInicio, Double valor) {
//        this.cliente = cliente;
//        this.veiculo = veiculo;
//        this.dias = dias;
//        this.dataInicio = dataInicio;
//        this.valor = valor;
//    }
    
//    public Cliente getCliente() {
//        return cliente;
//    }
//    
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//    
//    public Veiculo getVeiculo() {
//        return veiculo;
//    }
//    
//    public void setVeiculo(Veiculo veiculo) {
//        this.veiculo = veiculo;
//    }

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
