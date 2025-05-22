
package controller;

import interfaces.ICommonOperator;
import java.util.ArrayList;
import model.Cliente;
import model.Pedido;

/**
 *
 * @author Usuario
 */
public class ClienteController implements ICommonOperator<Cliente> {
    
    private ArrayList<Cliente> lista = new ArrayList<>();

    @Override
    public void execute() {
        
    }

    @Override
    public boolean create(Cliente c) {
         if (find(c.getId()) != -1) {
            return false;
        }
        lista.add(c);
        return true;
    }

    @Override
    public Cliente search(String id) {
         for(Cliente c : lista){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Cliente> toList() {
        return lista;
    }

    @Override
    public boolean update(Cliente c) {
            int index = find(c.getId());
        if (index != -1) {
            lista.set(index, c);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Cliente c) {
        int index = find(c.getId());
        if (index != -1) {
            lista.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public int find(String id) {
       for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                return i;
            }

        }
        return -1;
       
    }

}
