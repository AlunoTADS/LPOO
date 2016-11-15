
package Tarefa03;

/**
 *
 * @author edenm
 */

public class Diretor extends Funcionario {  //cria classe Diretorno herdando de classe funcionario

        private String [] departamento = new String[]{"Producao", "Montagem", "Expedicao"}; //Cria String departamento com nome Departamentos

        
    public double getBonus(){
        return getSalario() * 4 + 3000 * departamento.length;
    }
    
    public Diretor (double salario, double bonus, String nome){ //Construtor de diretor
        super(salario, bonus, nome);
    }
}
