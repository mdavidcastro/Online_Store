
package controller;

import interfaces.ICommonOperator;
import java.util.ArrayList;
import model.Pedido;

/**
 *
 * @author Usuario
 */

public class PedidoController implements ICommonOperator <Pedido> {
    
    //tocar importar la vistaPedido
    private ArrayList<Pedido> lista = new ArrayList<>();

    @Override
    public void execute() {
        
    }

    @Override
    public boolean create(Pedido p) {
       //verficar que el pedido no exista.
        if (find(p.getId()) != -1) {
        return false;
        }
        lista.add(p);
        return true;
    } 
    
    @Override
    public boolean update(Pedido p) {
        int index = find(p.getId());
        if(index != -1){
            lista.set(index, p);
            return true;
        }
        return false;
    }
    @Override
    public boolean delete(Pedido p) { 
       int index = find(p.getId());
        if(index != -1){
            lista.remove(index);
            return true;
        }
        return false;
    }
       
    @Override
    public Pedido search(String id){
        for(Pedido p : lista){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
   }
    @Override
    public int find(String id){
        for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getId().equals(id)){
            return i;
        }
            
    }
    return -1;
    }
   
 
    @Override
    public ArrayList<Pedido> toList() {
        
        return null;
        
    }
    
   
    
}
