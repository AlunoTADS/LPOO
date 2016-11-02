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
    
    KOMBI(1),
    SPRINTER(2),
    BESTA(3),
    DOBLO(4),
    TRANSIT(5);
    
    private int codigo;

    private ModeloVan(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }
}
