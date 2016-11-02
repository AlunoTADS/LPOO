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
public class Automovel extends Veiculo {

    private ModeloAutomovel modelo;

    public Automovel(ModeloAutomovel modelo, Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorCompra, String placa, Integer ano) {
        super(marca, estado, locacao, categoria, valorCompra, placa, ano);
        this.modelo = modelo;
    }

    public ModeloAutomovel getModelo() {
        return modelo;
    }

    public double getValorDiariaLocacao() {
        if (categoria == Categoria.POPULAR){
            return 100.00;
        }
        else if (categoria == Categoria.INTERMEDIARIO){
            return 300.00;
        }
        else if(categoria == Categoria.LUXO){
            return 450.00;
        }
        else
            return 0;
    }


}
