/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ClienteEspecial extends Cliente {

    private Double porcentajeDescuento;
    private ArrayList<String> promocionesExclusivas;

    public ClienteEspecial(Double porcentajeDescuento, String nombre, String direccion, String email, String telefono, String id) {
        super(nombre, direccion, email, telefono, id);
        this.promocionesExclusivas = new ArrayList<>();
    }

    /**
     * Aplica un descuento al total, si corresponde. Si no hay descuento
     * definido, retorna el total sin cambios.
     */
    public double aplicarDescuento(double total) {
        if (porcentajeDescuento != null) {
            return total * (1 - porcentajeDescuento);
        }
        return total;
    }

    /**
     * Agrega una promoción exclusiva al cliente especial.
     */
    public void agregarPromocion(String promocion) {
        promocionesExclusivas.add(promocion);
    }

}
