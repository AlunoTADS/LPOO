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
     
     private Integer idCategoria;
     private String descricao;
     
     Categoria(Integer idCategoria, String descricao){
         this.idCategoria = idCategoria;
         this.descricao = descricao;
     }
     
    public Integer getIdCategoria() {
        return idCategoria;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
