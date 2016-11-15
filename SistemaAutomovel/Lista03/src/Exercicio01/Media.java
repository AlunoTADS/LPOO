package Exercicio01;
import java.util.Scanner;

        
public class Media {
    public static void main(String [] args){
       int aux, media = 0, total = 0, cont = 0;
        Scanner scan = new Scanner(System.in);
        String str = "N";
        System.out.println("Entre com o numero");
        str = scan.next();
        while(!str.equals("S")){
            if(scan.hasNextInt()){ // verifica se argumento é inteiro
              aux = Integer.parseInt(str); //transforma a string em inteiro
              total += aux;
              cont ++;
              str = scan.next();
            }
            else{
                System.out.println("Caracter invalido");
                str = scan.next();
            }
            System.out.println("Digite outro numero");
        }
        System.out.println("Média= "+ total / cont);
    }
 }
