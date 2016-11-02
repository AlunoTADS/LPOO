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
    
    public Motocicleta (ModeloMotocicleta modelo, Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorCompra, String placa, int ano){
        super(null, marca, estado, locacao, categoria, valorCompra, placa, ano);
        this.modelo = modelo; 
    }
    
    public ModeloMotocicleta getModelo(){
        return modelo;
    }
    
    public double getValorDiariaLocacao(){
        if(categoria == Categoria.POPULAR){
                return 70.00;
        }
        else if(categoria == Categoria.INTERMEDIARIO){
                return 200.00;
        }
        else if (categoria == Categoria.LUXO){
                return 350.00;
        }
        else
            return 0;
    }
 
}
