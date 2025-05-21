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
    private String id;

    public Producto(String name, double price, String category, int cantidadDisponible, String id) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.cantidadDisponible = cantidadDisponible;
        this.id = id;
    }

    /**
     * Verifica si hay suficiente stock disponible para satisfacer una
     * solicitud.
     *
     * @param cantidadSolicitada la cantidad de unidades que se desean
     * verificar.
     * @return true si hay suficiente stock disponible, false en caso contrario.
     */
    public boolean hayStockDiponible(int cantidadSolicitada) {
        return cantidadDisponible >= cantidadSolicitada;
    }

    /**
     * Disminuye la cantidad de unidades en stock para este producto.
     *
     * @param cantidad la cantidad de unidades a restar del stock.
     * @throws IllegalArgumentException si la cantidad es negativa o mayor que
     * el stock disponible.
     */
    public void disminuirStock(int cantidad) {
        if (cantidad > 0 && cantidad <= cantidadDisponible) {
            cantidadDisponible -= cantidad;
        } else {
            throw new IllegalArgumentException("Cantidad inválida o insuficiente en stock.");
        }

    }

    /**
     * Aumenta la cantidad de unidades en stock para este producto.
     *
     * @param cantidad la cantidad de unidades a agregar al stock.
     * @throws IllegalArgumentException si la cantidad es negativa.
     */
    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            cantidadDisponible += cantidad;
            throw new IllegalArgumentException("La cantidad a aumentar debe ser positiva.");
        }
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    // Método para mostrar info del producto (opcional pero recomendado)
    @Override
    public String toString() {
        return "Producto{"
                + "nombre='" + name + '\''
                + ", precio=" + price
                + ", categoria='" + category + '\''
                + ", cantidadDisponible=" + cantidadDisponible
                + '}';
    }
}
