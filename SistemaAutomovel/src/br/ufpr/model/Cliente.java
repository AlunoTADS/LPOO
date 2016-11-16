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

    public Cliente(Integer idCliente, String nome, String sobrenome, String cpf, String rg, UnidadeFederativa rgUF, String endereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.rgUF = rgUF;
        this.endereco = endereco;
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente() {
    }

    @Column(label = "Cód", position = 0)
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    @Column(label = "Nome", position = 1)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(label = "Sobrenome", position = 2)
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Column(label = "CPF", position = 3)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(label = "RG", position = 4)
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Column(label = "RG UF", position = 5)
    public UnidadeFederativa getRgUF() {
        return rgUF;
    }

    public void setRgUF(UnidadeFederativa rgUF) {
        this.rgUF = rgUF;
    }

    @Column(label = "Endereço", position = 6)
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
