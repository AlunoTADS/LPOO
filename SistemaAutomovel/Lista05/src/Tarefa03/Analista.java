/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarefa03;

/**
 *
 * @author edenm
 */


public class Analista extends Funcionario {  //cria classe Analista herdando de classe funcionario

    
    
        public double getBonus(){
        return getSalario();
    }
    
    public Analista (double salario, double bonus, String nome){ //Construtor de Analista
        super(salario, bonus, nome);
    } 
    
}
