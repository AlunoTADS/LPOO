/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.model;

/**
 *
 * @author Giovanni
 */
public class Cliente {
    
    private Integer idCliente;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;
    private UnidadeFederativa rgUF;
    private String endereco;

    public Cliente(Integer idCliente, String nome, String sobrenome, String cpf, String rg, String endereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }    

    public Integer getIdCliente() {
        return this.idCliente;
    }
}
