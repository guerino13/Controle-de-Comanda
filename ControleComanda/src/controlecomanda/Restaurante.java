
package controlecomanda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {
    private String nome;
    private Comanda[] mesas = new Comanda[10];
    private ArrayList<Produto> menu = new ArrayList<>();

    public Restaurante(String nome) {
        this.nome = nome;
        carregaProdutos();
    }
    
    private void carregaProdutos(){
        this.menu.add(new Porcao(350.0, 1, 12.00, "Tropeiro"));
        this.menu.add(new Porcao(500.0, 3, 15.00, "Fritas"));
        this.menu.add(new Porcao(500.0, 2, 36.00, "File"));
        this.menu.add(new Bebida(380.0, true, 10.00, "Bebida da Massa"));
        this.menu.add(new Bebida(500.0, false, 10.00, "Suco"));
}
    
    public void realCadastroComanda(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o nome do cliente:");
        String nomeCli = sc.nextLine();
        
        
        System.out.println("Informe o numero do cliente:");
        String numCli = sc.nextLine();
        
        Cliente novoCli = new Cliente(nomeCli, numCli);
        
        System.out.println("Informe o numero da mesa do cliente:");
        int numMesa = sc.nextInt();
        
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
       
       Comanda c = mesas[numMesa];
       System.out.println("Numero da mesa: "+numMesa);
      
       System.out.println("\nPedidos realizados: ");
       for(Produto prod : c.getProdutos()){
           System.out.println(prod.toString());
       }
       
       System.out.println("\nTotal R$: "+c.getValorTotal());
       
   }
  
    
}

