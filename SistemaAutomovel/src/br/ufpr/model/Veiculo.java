package br.ufpr.model;

import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * A classe veículo deve ter os seguintes atributos: <br>
 * i. Criar um construtor com todos os atributos como parâmetro. <br>
 * ii. marca – Crie uma classe de nome Marca e do tipo enum para definir este
 * atributo. Pode assumir os seguintes valores (VW, GM, Fiat, Honda, Mercedes,
 * etc)  <br>
 * iii. estado - Crie uma classe de nome Estado e do tipo enum para definir este
 * atributo. Pode assumir os seguintes valores (NOVO, LOCADO, DISPONIVEL,
 * VENDIDO)  <br>
 * iv. locacao – Crie uma classe Locacao especificada no item 3. Este objeto
 * será nulo quando o estado do veículo for diferente de LOCADO. O objeto será
 * instanciado somente quando o veiculo for alugado (método alugar) e será
 * atribuído nulo quando o veículo for devolvido (método devolverAluguel)
 * <br>
 * v. categoria - Crie uma classe de nome Categoria e do tipo enum para definir
 * este atributo. Pode assumir os seguintes valores (POPULAR, INTERMEDIARIO,
 * LUXO). Este atributo írá definir o preço da diária de um aluguel <br>
 * vi. valorCompra – double que representa o valor de compra do veículo <br>
 * vii. placa – String. String no formato XXX-0000, onde X é um alfabético de A
 * a Z e 0 é um numério de 0 a 9 <br>
 * viii. ano – int. Inteiro representado o ano modelo do veículo <br>
 * ix. Não crie métodos de get e set para cada atributo. Crie somente os métodos
 * que estão descritos na interface VeiculoI
 *
 * @author Lucas
 */
public abstract class Veiculo implements VeiculoI {

    private Integer idVeiculo;
    protected Marca marca;
    protected Estado estado;
    protected Categoria categoria;
    protected Double valorCompra;
    protected String placa;
    protected Integer ano;
    protected Locacao locacao;

    /**
     * @param idVeiculo identificador do veiculo, deixar nulo para veiculos que
     * ainda não foram persistidos no banco de dados.
     * @param marca
     * @param estado
     * @param locacao nulo caso estado == Estado.LOCADO não esteja locado
     * @param categoria
     * @param valorCompra
     * @param placa a placa deve ser nula ou seguir a expressao regular
     * [A-Z]{3,3}-\\d{4,4}
     * @param ano ano do modelo do veiculo, não pode ser menor ou igual a zero.
     */
    public Veiculo(Integer idVeiculo, Marca marca, Estado estado, Locacao locacao, Categoria categoria, Double valorCompra, String placa, Integer ano) {

        if (placa != null && !Pattern.compile("[A-Z]{3,3}-\\d{4,4}").matcher(placa).matches()) {
            throw new IllegalArgumentException("placa não é um argumento valido");
        }

        if (estado == Estado.LOCADO && locacao == null) {
            throw new IllegalArgumentException("estado == Estado.LOCADO implica em locacao != null");
        }

        if (ano != null && ano <= 0) {
            throw new IllegalArgumentException("ano não pode ser <= 0");
        }

        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.estado = estado;
        this.locacao = locacao;
        this.categoria = categoria;
        this.valorCompra = valorCompra;
        this.placa = placa;
        this.ano = ano;
    }

    public Veiculo() {
    }

    @Override
    public void locar(int dias, Calendar dataInicio, Cliente cliente) {
        this.locacao = new Locacao(this.getIdVeiculo(), cliente, dias, dataInicio.getTime(), dias * this.getValorDiariaLocacao());
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

    /**
     * @return o idVeiculo
     */
    @Column(label = "Cód", position = 0, format = "%10d")
    public Integer getIdVeiculo() {
        return this.idVeiculo;
    }

    @Override
    @Column(label = "Placa", position = 1)
    public String getPlaca() {
        return this.placa;
    }

    @Override
    @Column(label = "Ano", position = 2, format = "%10d")
    public int getAno() {
        return this.ano;
    }

    @Override
    @Column(label = "Preço p/ Venda", position = 3, format = "R$ %10.2f")
    public double getValorParaVenda() {
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        double valorCompra = this.getValorCompra() == null ? 0.00 : this.getValorCompra();
        int idadeVeiculoEmAnos = Calendar.getInstance().get(Calendar.YEAR) - this.getAno();
        double valorVenda = valorCompra - idadeVeiculoEmAnos * 0.15 * valorCompra;
        if (valorVenda < 0.00 || valorVenda < 0.10 * valorCompra) {
            valorVenda = 0.10 * valorCompra;
        }
        return valorVenda;
    }

    @Column(label = "Marca", position = 4)
    public String getMarcaDescricao() {
        return this.marca != null ? this.marca.getDescricao() : "";
    }

    @Column(label = "Categoria", position = 5)
    public String getCategoriaDescricao() {
        return this.marca != null ? this.categoria.getDescricao() : "";
    }

    @Column(label = "Vlr Dia Locação", position = 6, format = "R$ %10.2f")
    public abstract double getValorDiariaLocacao();

//    @Column(label = "Valor Compra", position = 5, format = "%10.2f")
    public Double getValorCompra() {
        return this.valorCompra;
    }

    @Column(label = "Estado", position = 7)
    public String getEstadoDescricao() {
        return this.estado != null ? this.estado.getDescricao() : "";
    }

    @Override
    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public Marca getMarca() {
        return this.marca;
    }

    @Override
    public Categoria getCategoria() {
        return this.categoria;
    }

    @Override
    public Locacao getLocacao() {
        return this.locacao;
    }

}
