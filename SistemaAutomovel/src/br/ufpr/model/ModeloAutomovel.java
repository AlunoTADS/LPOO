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

     private Integer idModeloAutomovel;
     private String descricao;
     
     ModeloAutomovel(Integer idModeloAutomovel, String descricao){
         this.idModeloAutomovel = idModeloAutomovel;
         this.descricao = descricao;
     }
    public Integer getIdModeloAutomovel() {
        return idModeloAutomovel;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
