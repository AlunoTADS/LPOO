package br.ufpr.model;

/**
 *
 * @author Matheus
 */
public class Motocicleta extends Veiculo {
    
    private ModeloMotocicleta modelo;
    
    public Motocicleta (Integer idVeiculo,ModeloMotocicleta modelo, Marca marca, Estado estado, Locacao locacao, Categoria categoria, Double valorCompra, String placa, Integer ano){
        super(idVeiculo, marca, estado, locacao, categoria, valorCompra, placa, ano);
        this.modelo = modelo; 
    }
    
    public Motocicleta() {
    }
    
    public ModeloMotocicleta getModelo(){
        return modelo;
    }
    
    @Override
    public double getValorDiariaLocacao(){
        if(categoria == Categoria.POPULAR){
                return 70.00;
        }
        else if(categoria == Categoria.INTERMEDIARIO){
                return 200.00;
        }
        else if (categoria == Categoria.LUXO){
                return 350.00;
        }
        else {
            return 0;
        }
    }
 
}
