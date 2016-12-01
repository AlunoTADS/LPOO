package br.ufpr.model;

/**
 *
 * @author Matheus
 */
public class Automovel extends Veiculo {

    private ModeloAutomovel modelo;

    public Automovel(ModeloAutomovel modelo, Marca marca, Estado estado, Locacao locacao, Categoria categoria, Double valorCompra, String placa, Integer ano) {
        super(null, marca, estado, locacao, categoria, valorCompra, placa, ano);
        this.modelo = modelo;
    }
    
    public Automovel() {
    }

    public ModeloAutomovel getModelo() {
        return modelo;
    }

    @Override
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
        else {
            return 0;
        }
    }


}
