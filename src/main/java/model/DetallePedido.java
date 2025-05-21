/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */
public class DetallePedido {
    
    private Producto producto;
    private int cantidad;
    private double precio;

    public DetallePedido(Producto producto, int cantidad) {
        
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = this.producto.getPrice();
        
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getTotal(){
        double total = precio*cantidad;
     return total;   
    }
    
    
    
    
}
