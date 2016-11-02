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

    public Automovel(ModeloAutomovel modelo, Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano) {
        super(null, marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    public ModeloAutomovel getModelo() {
        return modelo;
    }

    public double getValorDiariaLocacao() {
        switch (categoria){
            case (Categoria.POPULAR):
                return 100.00;
            case (Categoria.INTERMEDIARIO):
                return 300.00;
            case (Categoria.LUXO):
                return 450.00;
        }
    }

}
