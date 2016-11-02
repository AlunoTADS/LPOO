package br.ufpr.model;

import java.util.Calendar;

/**
 *
 * @author Lucas
 */
public abstract class Veiculo implements VeiculoI {

    private Integer idVeiculo;
    private Marca marca;
    private Estado estado;
    private Categoria categoria;
    private Double valorCompra;
    private String placa;
    private Integer ano;
    private Locacao locacao;

    /**
     *
     * @param marca
     * @param estado
     * @param locacao
     * @param categoria
     * @param valorCompra
     * @param placa
     * @param ano
     */
    public Veiculo(Marca marca, Estado estado, Locacao locacao, Categoria categoria, Double valorCompra, String placa, Integer ano) {
        this.marca = marca;
        this.estado = estado;
        this.locacao = locacao;
        this.categoria = categoria;
        this.valorCompra = valorCompra;
        this.placa = placa;
        this.ano = ano;
    }
    
    @Override
    public void locar(int dias, Calendar dataInicio, Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vender() {
        this.estado = Estado.VENDIDO;
    }

    @Override
    public void devolver() {
        this.estado = Estado.DISPONIVEL;
    }

    @Override
    public double getValorParaVenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public Marca getMarca() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria getCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Locacao getLocacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPlaca() {
        return this.placa;
    }

    @Override
    public int getAno() {
        return this.ano;
    }

    @Override
    public double getValorDiariaLocacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
