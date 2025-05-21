
package controller;

import interfaces.ICommonOperator;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author Usuario
 */
public class ClienteController implements ICommonOperator<Cliente> {
    private ArrayList<Cliente> lista = new ArrayList<>();

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> toList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
