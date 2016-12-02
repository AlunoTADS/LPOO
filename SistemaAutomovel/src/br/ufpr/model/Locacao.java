package br.ufpr.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Giovanni
 */
public class Locacao {

    private Integer idVeiculo;
    private Cliente cliente;
    private Integer dias;
    private Date dataInicio;
    private Double valor;

    public Locacao(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Locacao(Integer idVeiculo, Cliente cliente, Integer dias, Date dataInicio, Double valor) {
        this.idVeiculo = idVeiculo;
        this.cliente = cliente;
        this.dias = dias;
        this.dataInicio = dataInicio;
        this.valor = valor;
    }

    @Column(label = "Cód. Veiculo", position = 0)
    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    @Column(label = "Cliente", position = 1)
    public String getClienteNome() {
        return cliente.getNome();
    }

    @Column(label = "CPF", position = 2)
    public String getClienteCpf() {
        return cliente.getCpf();
    }

    @Column(label = "Data Inicio", position = 3)
    public String getDataInicioFormatada() {
        return dataInicio != null ? new SimpleDateFormat("dd/MM/yyyy").format(dataInicio) : "";
    }

    @Column(label = "Dias", position = 4, format = "%10d")
    public Integer getDias() {
        return dias;
    }

    @Column(label = "Valor", position = 5, format = "R$ %10.2f")
    public Double getValor() {
        return valor;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
