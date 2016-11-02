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
public enum Marca {
    
    VW(1, "Volkswagen"),
    GM(2, "General Motors"),
    FIAT(3, "Fiat"),
    HONDA(4, "Honda"),
    MERCEDES(5, "Mercedes"),
    VOLVO(6, "Volvo"),
    AUDI(7, "Audi"),
    FORD(8, "Ford"),
    KIA(9, "KIA"),
    TOYOTA(10, "Toyota"),
    LAND_ROVER(11, "Land Rover"),
    DODGE(12, "Dodge"),
    JAGUAR(13, "Jaguar"),
    PORSCHE(14, "Porsche");
    
    private Integer codigo;
    private String descricao;

    private Marca(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public Integer getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
