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
     NOVO(1), LOCADO(2), DISPONIVEL(3), VENDIDO(4);
     
     private final int estado;
     Estado(int valorEstado){
         estado = valorEstado;
     }
     
     public int getEstado(){
         return estado;
     }
}

