
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Pedido {
    
    public enum EstadoPedido{
    EN_PREPARACION,
    ENVIADO,
    ENTREGADO
    }
    
    private Cliente cliente;
    private ArrayList<DetallePedido> detalles;//Lista de productos y cantidades
    private String fechaCompra;
    private String id;
    private EstadoPedido estado;
   
    public Pedido(Cliente cliente) {
        
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.fechaCompra = fechaCompra;
        this.estado = estado.EN_PREPARACION;
        this.id = id;
    }
    
    public void agregarDetalle(Producto producto, int cantidad){
        detalles.add(new DetallePedido(producto,cantidad));
        costoTotal();
    }
    
    public double costoTotal() {
        
        double subtotal = 0.0;
        for (DetallePedido detalle : detalles) {
            subtotal += detalle.getTotal(); 
        }
        
        if (cliente instanceof ClienteEspecial) {
            ClienteEspecial clienteEsp = (ClienteEspecial) cliente;
            subtotal = clienteEsp.aplicarDescuento(subtotal);
        } 
        
        return subtotal;
    }
    
      /**
     * Avanza el estado del pedido al siguiente, según el flujo lógico.
     * - EN_PREPARACION -> ENVIADO
     * - ENVIADO -> ENTREGADO
     * - ENTREGADO (no cambia más)
     * @return true si el estado cambió, false si ya estaba en ENTREGADO.
     */
    public boolean avanzarEstado() {
        switch (estado) {
            case EN_PREPARACION:
                estado = EstadoPedido.ENVIADO;
                return true;
            case ENVIADO:
                estado = EstadoPedido.ENTREGADO;
                return true;
            case ENTREGADO:
                // Ya está en el último estado, no avanza más.
                return false;
            default:
                return false;
        }
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
    
    
    
    
            
    
}
