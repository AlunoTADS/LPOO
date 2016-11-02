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
public enum Categoria {
     POPULAR(1, "Popular"),
     INTERMEDIARIO(2, "Intermediario"),
     LUXO(3, "Luxo");
     
     private Integer codigo;
     private String descricao;
     
     Categoria(Integer codigo, String descricao){
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
