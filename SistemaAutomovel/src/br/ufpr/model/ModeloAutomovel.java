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
     GOL(1), CELTA(2), PALIO(3), CORSA(4);/*Quem quiser adicionar valores aqui, fique a vontade*/
     
     private final int modeloAutomovel;
     ModeloAutomovel(int valorModelo){
         modeloAutomovel = valorModelo;
     }
     
     public int getModelo(){
         return modeloAutomovel;
     }
}