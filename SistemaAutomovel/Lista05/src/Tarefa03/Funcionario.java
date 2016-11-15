
package Tarefa03;

/**
 *
 * @author edenm
 */
abstract class Funcionario { //Cria classe abstrata funcionario
    private double salario, bonus;
    private String nome;

   public Funcionario (double salario, double bonus, String nome) { //Construtor da classe funcionario
       this.bonus = bonus;
       this.salario = salario;
       this.nome = nome;
   }
   
   public abstract double getBonus();

    public double getSalario() { //Cria getSalario
        return salario; //retorna salario
    }

    public String getNome() { //Cria getNome
        return nome; //Retorna nome
    }
    
    
    public String imprimeFuncionario(){ //Metodo para listar funcionarios
        return "\nNome: "+getNome()
                + "\nSalario: "+getSalario()
                + "\nBonus: "+getBonus();
    }
}
