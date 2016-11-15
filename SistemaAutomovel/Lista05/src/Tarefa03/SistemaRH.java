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
public class SistemaRH {
    private static Funcionario[] lista; //Criando arrai de funcionario
    public static void main(String [] args){
        Diretor dir=new Diretor (16000.0, 0, "Danieli"); //Instanciando
        Gerente ger=new Gerente(4000.0, 0,"Luiz"); //Instanciando
        Analista ana=new Analista (2500.0, 0,"Antonio"); //Instanciando
    lista = new Funcionario[]{dir, ger, ana}; //array lista recebe objetos funcionario
    imprimeRelatorio(lista);//chama metodo imprime relatorio passando lista como parametro
    }
    
    public static void imprimeRelatorio(Funcionario[] listaFuncionarios){ //for avançado
        for (Funcionario lista1 : lista) // captura itens de lista e cria copia em lista1
            System.out.println(lista1.imprimeFuncionario()); //imprime conteudo lista1 usando metodo da classe funcionario       
    }
    
}
