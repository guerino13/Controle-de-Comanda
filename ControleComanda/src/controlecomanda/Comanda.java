
package controlecomanda;

import java.time.LocalDate;
import java.util.ArrayList;


public class Comanda {
    private LocalDate data;
    private int numMesa;
    private double valorTotal;
    private Cliente cliente; 

   
    private ArrayList<Produto> produtos = new ArrayList<>(); 

    public Comanda(int numMesa, Cliente cliente) {
        this.numMesa = numMesa;
        this.cliente = cliente;
        this.valorTotal = 0.0;
        this.data = LocalDate.now();
    }
    
    public void anotaPedido(Produto novoPedido){
        this.produtos.add(novoPedido);
        this.valorTotal += novoPedido.getValorUnit();
    }
    
    
    
}
