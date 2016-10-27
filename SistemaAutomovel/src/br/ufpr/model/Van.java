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

    public Van(ModeloAutomovel modelo, Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano) {
        super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    public ModeloAutomovel getModelo() {
        return modelo;
    }

    double getValorDiariaLocacao() {
        switch (categoria){
            case (Categoria.POPULAR):
                return 200.00;
            case (Categoria.INTERMEDIARIO):
                return 400.00;
            case (Categoria.LUXO):
                return 600.00;
        }
    }

}
