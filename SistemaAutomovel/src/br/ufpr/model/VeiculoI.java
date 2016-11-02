package br.ufpr.model;

import java.util.Calendar;

/**
 *
 * @author Lucas
 */
public interface VeiculoI {

    /**
     * Muda estado para LOCADO. 
     * Cria uma instância de Locacao e armazena no atributo locacao. 
     * Chama o método getValorDiariaLocacao para calcular o valor da locação. 
     * 
     * @param dias quantidade de dias que o veiculo esta locado
     * @param dataInicio data de inicio da locação
     * @param cliente cliente que esta locando
     */    
    public void locar(int dias, Calendar dataInicio, Cliente cliente);

    /**
     * Muda estado para VENDIDO e não pode mais ser alugado 
     */
    public void vender();  

    /**
     * Muda estado para DISPONIVEL
     */
    public void devolver();

    /**
     * Método que calcula um valor para venda
     * @return valor 
     *      valor = valorCompra – idadeVeiculoEmAnos * 0,15 * valorCompra <br>
     *      Se o resultado for menor do que 10% do valorCompra ou negativo, 
     *      então <br>  
     *      valor = valorCompra*0,1 
     * 
     */
    public double getValorParaVenda();    
    
    public Estado getEstado();

    public Marca getMarca();

    public Categoria getCategoria();

    public Locacao getLocacao();

    public String getPlaca();

    public int getAno();
    
    public double getValorDiariaLocacao();
}
