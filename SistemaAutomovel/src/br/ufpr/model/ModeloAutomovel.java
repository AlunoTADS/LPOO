/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.model;

/**
 *
 * @author Matheus
 */
public enum ModeloAutomovel {
     GOL(1, "Gol"),
     CELTA(2, "Celta"),
     PALIO(3, "Palio"),
     CORSA(4, "Corsa");/*Quem quiser adicionar valores aqui, fique a vontade*/
     
     private Integer codigo;
     private String descricao;
     
     ModeloAutomovel(Integer codigo, String descricao){
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