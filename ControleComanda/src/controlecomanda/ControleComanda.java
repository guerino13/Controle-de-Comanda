
package controlecomanda;

import java.util.ArrayList;
import java.util.Scanner;


public class ControleComanda {
  
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
       
        Restaurante restAvenida = new Restaurante("Mariza Sunset");
        
        while(true){
            System.out.println("1 - Cadastrar comanda \n2 - Realizar pedido \n3 - Fechar comanda \n4 - Encerrar o dia");   
            int opcao = sc.nextInt();
            
            switch (opcao) {
                case 1: restAvenida.realCadastroComanda();break;
                
                case 2: restAvenida.realizarPedido();break;
                
                case 3: restAvenida.fecharComanda();break;
                 
                case 4: break;
                
            }
        }

            
    }    
}
