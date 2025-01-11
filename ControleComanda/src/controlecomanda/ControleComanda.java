
package controlecomanda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ControleComanda {
    public static void testeEscrita(){
        Scanner sc =  new Scanner(System.in);
        String textoLinha = null;
        
        File arquivo = new File("C:\\Users\\0077784\\Downloads\\textoUsuario.txt");
       
        try{
             FileWriter marcaEscrita = new FileWriter(arquivo);
             
             BufferedWriter bufEscrita = new BufferedWriter(marcaEscrita);
        do{
            textoLinha = sc.nextLine();
            if(!textoLinha.equalsIgnoreCase("sair"))
            bufEscrita.write(textoLinha + "\n");
        }while(!textoLinha.equalsIgnoreCase("sair"));
        
       bufEscrita.flush();
       bufEscrita.close();
       
         }catch(IOException err){
            System.out.println("Arquivo comrrompido!");
        }
    }

    
    public static void main(String[] args) {
    
   
        
        Scanner sc = new Scanner(System.in);
       
        Restaurante restAvenida = new Restaurante("Mariza Sunset");
        
        while(true){
            System.out.println("1 - Cadastrar comanda \n2 - Realizar pedido \n3 - Fechar comanda \n4 - Encerrar o dia \n");   
            int opcao = sc.nextInt();
            
            switch (opcao) {
                case 1: restAvenida.realCadastroComanda();break;
                
                case 2: restAvenida.realizarPedido();break;
                
                case 3:System.out.println("Informe o numero da mesa: ");
                    
                restAvenida.fecharComanda(sc.nextInt());break;
                
                 
                case 4: return;
                
            }
        }

            
    }    
}
