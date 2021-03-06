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
    
    private Integer idModeloVan;
    private String descricao;
    
    private ModeloVan(Integer idModeloVan, String descricao) {
        this.idModeloVan = idModeloVan;
        this.descricao = descricao;
    }
    
    public static ModeloVan fromValue(Integer idModeloVan) {
        for (ModeloVan modelo : ModeloVan.values()) {
            if (modelo.getIdModeloVan() == idModeloVan) {
                return modelo;
            }
        }
        return null;
    }

    public Integer getIdModeloVan() {
        return idModeloVan;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    @Override
    public String toString() {
        return getDescricao();
    }
}