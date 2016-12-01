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
public class Van extends Veiculo {

    private ModeloVan modelo;

    public Van(ModeloVan modelo, Marca marca, Estado estado, Locacao locacao, Categoria categoria, Double valorDeCompra, String placa, Integer ano) {
        super(null, marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }
    
    public Van() {
    }

    public ModeloVan getModelo() {
        return modelo;
    }

    public double getValorDiariaLocacao() {
        if (categoria == Categoria.POPULAR){
                return 200.00;
        }
        else if(categoria == Categoria.INTERMEDIARIO){
                return 400.00;
        }
        else if (categoria == Categoria.LUXO){
                return 600.00;
        }
        else
            return 0;
    }

}
