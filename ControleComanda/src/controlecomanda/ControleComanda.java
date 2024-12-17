
package controlecomanda;

import java.util.ArrayList;
import java.util.Scanner;


public class ControleComanda {
  
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
       
        Restaurante restAvenida = new Restaurante("Mariza Sunset");
        boolean continuar = true;
        while(continuar){
            System.out.println("1 - Cadastrar comanda \n2 - Realizar pedido \n3 - Fechar comanda \n4 - Encerrar o dia \n");   
            int opcao = sc.nextInt();
            
            switch (opcao) {
                case 1: restAvenida.realCadastroComanda();break;
                
                case 2: restAvenida.realizarPedido();break;
                
                case 3: 
                    System.out.println("Informe o numero da mesa: ");
                    restAvenida.fecharComanda(sc.nextInt());break;
                 
                case 4: continuar = false;break;
                
            }
        }

            
    }    
}
