
package view;

import Utilidades.Util;
import controller.ClienteController;
import interfaces.IView;
import model.Cliente;

/**
 *
 * @author Usuario
 */
public class ClienteView implements IView {

    private ClienteController clienteController;

    public ClienteView(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    @Override
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ CLIENTES ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Listar clientes");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Salir");

            opcion = Util.getInt("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrar();
                    break;
                case 2:
                    mostrarElemento();
                    break;
                case 3:
                    mostrarLista();
                    break;
                case 4:
                    actualizar();
                    break;
                case 5:
                    eliminar();
                    break;
                case 0:
                    System.out.println("Saliendo del menú de clientes.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    @Override
    public void mostrarElemento() {
        System.out.println("Buscar CLIENTE POR ID");
        String cedula = Util.getLine("Por favor, ingrese el número de identificación del cliente");
        Cliente cliente = this.clienteController.search(cedula);
        if (cliente != null) {
            System.out.println("Cliente encontrado");
            System.out.println(cliente);
        } else {
            System.out.println("No existe un cliente con ese #de identificacion");
        }

    }

    @Override
    public void mostrarLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void registrar() {
        System.out.println("Registrar un nuevo Cliente");
        String nombre = Util.getLine("Ingrese su nombre: ");
        String direccion = Util.getLine("Ingrese su direccion: ");
        String email = Util.getLine("Ingrese su email");
        String telefono = Util.getLine("Ingrese su telefono");
        String id = Util.getLine("Ingrese su id");
        Cliente cliente = new Cliente(nombre, direccion, email, telefono, id);
        this.clienteController.create(cliente);
        boolean creado = clienteController.create(cliente);
        if (creado) {
            System.out.println("Cliente creado existosamente!");
        } else {
            System.out.println("Ya existe un cliente con ese ID");
        }

    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
