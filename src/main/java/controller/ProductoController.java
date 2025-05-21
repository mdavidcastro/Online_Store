/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import interfaces.ICommonOperator;
import java.util.ArrayList;
import model.Producto;

/**
 *
 * @author Usuario
 */
public class ProductoController implements ICommonOperator<Producto> {

    private ArrayList<Producto> lista = new ArrayList<>();

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Producto> toList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
