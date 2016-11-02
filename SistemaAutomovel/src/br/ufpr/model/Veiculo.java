package br.ufpr.model;

import java.util.Calendar;

/**
 * A classe veículo deve ter os seguintes atributos: <br>
 *  i. Criar um construtor com todos os atributos como parâmetro. <br>
 *  ii. marca – Crie uma classe de nome Marca e do tipo enum para definir este 
 *  atributo. Pode assumir os seguintes valores (VW, GM, Fiat, Honda, Mercedes, 
 *  etc)  <br>
 *  iii. estado - Crie uma classe de nome Estado e do tipo enum para definir 
 *  este atributo. Pode assumir os seguintes valores (NOVO, LOCADO, DISPONIVEL, 
 *  VENDIDO)  <br>
 *  iv. locacao – Crie uma classe Locacao especificada no item 3. Este objeto 
 *  será nulo quando o estado do veículo for diferente de LOCADO. O objeto 
 *  será instanciado somente quando o veiculo for alugado (método alugar) e 
 *  será atribuído nulo quando o veículo for devolvido (método devolverAluguel)
 *  <br>
 *  v. categoria - Crie uma classe de nome Categoria e do tipo enum para 
 *  definir este atributo. Pode assumir os seguintes valores (POPULAR, 
 *  INTERMEDIARIO, LUXO). Este atributo írá definir o preço da diária de 
 *  um aluguel <br>
 *  vi. valorCompra – double que representa o valor de compra do veículo <br>
 *  vii. placa – String. String no formato XXX-0000, onde X é um alfabético 
 *  de A a Z e 0 é um numério de 0 a 9 <br>
 *  viii. ano – int. Inteiro representado o ano modelo do veículo <br>
 *  ix. Não crie métodos de get e set para cada atributo. Crie somente os 
 *  métodos que estão descritos na interface VeiculoI
 * 
 * @author Lucas
 */
public abstract class Veiculo implements VeiculoI {

    protected Integer idVeiculo;
    protected Marca marca;
    protected Estado estado;
    protected Categoria categoria;
    protected Double valorCompra;
    protected String placa;
    protected Integer ano;
    protected Locacao locacao;

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
        this.locacao = new Locacao(cliente, this, dias, dataInicio, valorCompra);
        this.estado = Estado.LOCADO;
    }

    @Override
    public void vender() {
        this.estado = Estado.VENDIDO;
    }

    @Override
    public void devolver() {
        this.locacao = null;
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

}
