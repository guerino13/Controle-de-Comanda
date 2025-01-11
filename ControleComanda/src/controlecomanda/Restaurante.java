
package controlecomanda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {
    private String nome;
    private Comanda[] mesas = new Comanda[10];
    private ArrayList<Produto> menu = new ArrayList<>();

    public Restaurante(String nome) {
        this.nome = nome;
        carregaProdutoMenu();
    }
//    
//    private void carregaProdutos(){
//        this.menu.add(new Porcao(350.0, 1, 12.00, "Tropeiro"));
//        this.menu.add(new Porcao(500.0, 3, 15.00, "Fritas"));
//        this.menu.add(new Porcao(500.0, 2, 36.00, "File"));
//        this.menu.add(new Bebida(380.0, true, 10.00, "Bebida da Massa"));
//        this.menu.add(new Bebida(500.0, false, 10.00, "Suco"));
//}
    
    public void realCadastroComanda(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o nome do cliente:");
        String nomeCli = sc.nextLine();
        
        
        System.out.println("Informe o numero do cliente:");
        String numCli = sc.nextLine();
        
        Cliente novoCli = new Cliente(nomeCli, numCli);
        
        System.out.println("Informe o numero da mesa do cliente:");
        int numMesa = sc.nextInt();
        
         if(mesas[numMesa] != null){
            System.out.println("Mesa ja ocupada. Por favor, informe outra mesa.");
            numMesa = sc.nextInt();
        }
        
        Comanda novaComanda = new Comanda(numMesa, novoCli);
        mesas[numMesa] = novaComanda;
       
    }
    
    public boolean realizarPedido(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe o numero da mesa:");
        int numMesa = sc.nextInt();
        
        if(numMesa < 0 || numMesa > 9 || mesas[numMesa] == null){
            return false;
        } else{
            System.out.println("Informe o produto do pedido:");
            //imprimir o menu
             for(int i = 0; i < this.menu.size();i++){
                System.out.println((i+1)+ " - " +  this.menu.get(i));
            }
            int numProduto = sc.nextInt();
            numProduto--;
            this.mesas[numMesa].anotaPedido(this.menu.get(numProduto));
         return true;   
        }
        
        
    }
    
   public void fecharComanda(int numMesa){
       
      LocalDateTime fechamento = LocalDateTime.now();
       
       
       try{
           Comanda c = mesas[numMesa];
       System.out.println("Numero da mesa: "+numMesa);
      
       System.out.println("\nPedidos realizados: ");
       for(Produto prod : c.getProdutos()){
           System.out.println(prod.toString());
       }
       
       System.out.println("\nTotal R$: "+c.getValorTotal());
       
       this.mesas[numMesa] = null;
          
      } catch(NullPointerException err){
          System.err.println("Comanda ja fechada ou inexistente. Informe outra comanda.");
      }
      
      File comandaFechada = new File("C:\\Users\\0077784\\Downloads\\.txt" +numMesa);
      
      
      
      
       
   }
   
       private void carregaProdutoMenu(){
//       1 - encontrar o arquivo
        File arquivo = new File("C:\\Users\\0077784\\Downloads\\refeicoes_e_bebidas.csv");

//       2 - marcar como leitura
       try{
        if(arquivo.exists() && arquivo.canRead() && arquivo.isFile()){
            FileReader marcaLeitura = new FileReader(arquivo);
            
            BufferedReader bufLeitura = new BufferedReader(marcaLeitura);
            
           String linha =  bufLeitura.readLine();
           
           while(linha != null){
               linha = bufLeitura.readLine();
             
               if(linha != null){
               String pedacosLinha[] = linha.split(";");
               
               Produto novoProduto = new Produto(Double.parseDouble(pedacosLinha[1]), pedacosLinha[0]);
               this.menu.add(novoProduto);
             }
             
             
           }
        }
       } catch(FileNotFoundException err){
           System.out.println("Caminho de arquivo incorreto!");
       } catch(IOException err){
           System.out.println("Erro na leitura dos dados!");
       }




    }
       
    
       
    
}

