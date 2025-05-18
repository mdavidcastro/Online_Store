/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */
public class Producto {
    private String name;
    private double price;
    private String category;
    private int cantidadDisponible; 

    public Producto(String name, double price, String category, int cantidadDisponible) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    
      // Método para mostrar info del producto (opcional pero recomendado)
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + name + '\'' +
                ", precio=" + price +
                ", categoria='" + category + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }
}
