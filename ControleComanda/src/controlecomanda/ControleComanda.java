
package controlecomanda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ControleComanda {
    
    public static void testeLeitura(){
//       1 - encontrar o arquivo
        File arquivo = new File("C:\\Users\\0077784\\Downloads\\refeicoes_e_bebidas.csv");

//       2 - marcar como leitura
       try{
        if(arquivo.exists() && arquivo.canRead() && arquivo.isFile()){
            FileReader marcaLeitura = new FileReader(arquivo);
            
            BufferedReader bufLeitura = new BufferedReader(marcaLeitura);
            
           String linha =  bufLeitura.readLine();
         
        }
       } catch(FileNotFoundException err){
           System.out.println("Caminho de arquivo incorreto!");
       } catch(IOException err){
           System.out.println("Erro na leitura dos dados!");
       }
//       3 - ler linhas do arquivo   



    }
    
    public static void main(String[] args) {
    
        testeLeitura();
        
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
