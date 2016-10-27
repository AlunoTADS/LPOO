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
public class Motocicleta extends Veiculo {
    
    private ModeloMotocicleta modelo;
    
    public Motocicleta (ModeloMotocicleta modelo, Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano){
        super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo; 
    }
    
    public ModeloMotocicleta getModelo(){
        return modelo;
    }
    
    double getValorDiariaLocacao(){
        switch (categoria){
            case (Categoria.POPULAR):
                return 70.00;
            case (Categoria.INTERMEDIARIO):
                return 200.00;
            case (Categoria.LUXO):
                return 350.00;
        }
    }
 
}