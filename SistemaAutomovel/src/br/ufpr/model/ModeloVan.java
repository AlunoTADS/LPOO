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
public enum ModeloVan {
    
    KOMBI(1, "Kombi"),
    SPRINTER(2, "Sprinter"),
    BESTA(3, "Besta"),
    DOBLO(4, "Doblo"),
    TRANSIT(5, "Transit");
    
    private Integer codigo;
    private String descricao;

    private ModeloVan(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }
}