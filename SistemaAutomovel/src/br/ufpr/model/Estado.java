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
public enum Estado {
    NOVO(1, "Novo"),
    LOCADO(2, "Locado"),
    DISPONIVEL(3, "Disponivel"),
    VENDIDO(4, "Vendido");

    private Integer codigo;
    private String descricao;

    private Estado(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public static Estado fromValue(Integer codigo) {
        for (Estado estado : Estado.values()) {
            if (estado.getCodigo() == codigo) {
                return estado;
            }
        }
        return null;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
