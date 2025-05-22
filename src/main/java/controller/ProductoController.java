
package controller;

import interfaces.ICommonOperator;
import java.util.ArrayList;
import model.Pedido;
import model.Producto;

/**
 *
 * @author Usuario
 */
public class ProductoController implements ICommonOperator<Producto> {

    private ArrayList<Producto> lista = new ArrayList<>();
    
    public boolean hayStockDisponible(String id, int cantidadSolicida){
        int idx = find(id);
        if(idx != -1){
            return lista.get(idx).hayStockDiponible(cantidadSolicida);
        }
        return false;
     }
    public boolean disminuirStock(String id, int cantidad){
        int idx = find(id);
        if(idx != -1){
            try{
                lista.get(idx).disminuirStock(cantidad);
                return true;
            } catch(IllegalArgumentException e){
                return false;
            }
        }
        return false;
    }
    
    public boolean aumentarStock(String id, int cantidad){
        int idx = find(id);
        if(idx != -1){
            try{
                lista.get(idx).aumentarStock(cantidad);
                return true;
            }catch (IllegalArgumentException e){
                return false;
            }
            
        }
        return false;
    }
    
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean create(Producto p) {
        if (find(p.getId()) != -1) {
            return false;
        }
        lista.add(p);
        return true;
    }

    @Override
    public Producto search(String id) {
         for(Producto p : lista){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Producto> toList() {
        return lista;
    }

    @Override
    public boolean update(Producto p) {
        int index = find(p.getId());
        if (index != -1) {
            lista.set(index, p);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Producto p) {
        int index = find(p.getId());
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
