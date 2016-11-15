
package Tarefa03;

/**
 *
 * @author edenm
 */

public class Gerente extends Funcionario {  //cria classe gerente herdando de classe funcionario

    private String [] lidera = new String[]{"Eden", "Giovani", "Matheus", "Lucas", "Wesley"}; //Informa parâmetros

    
   
    public double getBonus(){  // Cria método getBonus
        return getSalario() * 2 + 100 * lidera.length;
    }
    
    public Gerente (double salario, double bonus, String nome){ //Construtor de gerente
        super(salario, bonus, nome); // Utilizando construtor herdado de Funcionario
    }  
}
