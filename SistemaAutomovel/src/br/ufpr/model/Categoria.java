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
     POPULAR(1), INTERMEDIARIO(2), LUXO(3);
     
     private final int categoria;
     Categoria(int valorCategoria){
         categoria = valorCategoria;
     }
     
     public int getCategoria(){
         return categoria;
     }
}
