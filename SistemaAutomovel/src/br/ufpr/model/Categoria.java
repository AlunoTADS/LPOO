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

    private Categoria(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Categoria fromValue(Integer codigo) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getCodigo() == codigo) {
                return categoria;
            }
        }
        return null;
    }

    public Integer getCodigo() {
        return codigo;
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
