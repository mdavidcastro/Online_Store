
package view;

import Utilidades.Util;
import controller.ClienteController;
import interfaces.IView;
import java.util.ArrayList;
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
        ArrayList<Cliente> clientes = clienteController.toList();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("\n--- Lista de Clientes ---");
            for (Cliente cliente : clientes){ 
                System.out.println(cliente);
                System.out.println("-------------------------");
            }
        }
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
        System.out.println("Actualizar usuario");
        String id = Util.getLine("Ingrese su id");
        Cliente cliente = clienteController.search(id);
        if (cliente != null) {
            System.out.println("El cliente existe!");
            System.out.println("\n--- Datos actuales ---");
            System.out.println(cliente);

            System.out.println("-------");
            System.out.println("Nombre: " + cliente.getNombre());
            if (Util.getLine("¿Desea cambiar el nombre? (s/n): ").equalsIgnoreCase("s")) {
                String nuevoNombre = Util.getLine("Nuevo nombre: ");
                cliente.setNombre(nuevoNombre);
            }
            System.out.println("Direccion: " + cliente.getDireccion());
            if (Util.getLine("¿Desea cambiar la direccion? (s/n): ").equalsIgnoreCase("s")) {
                String nuevaDireccion = Util.getLine("Nuevo nombre: ");
                cliente.setNombre(nuevaDireccion);
            }
            System.out.println("Nombre: " + cliente.getNombre());
            if (Util.getLine("¿Desea cambiar el nombre? (s/n): ").equalsIgnoreCase("s")) {
                String nuevoNombre = Util.getLine("Nuevo nombre: ");
                cliente.setNombre(nuevoNombre);
            }
            System.out.println("Nombre: " + cliente.getNombre());
            if (Util.getLine("¿Desea cambiar el nombre? (s/n): ").equalsIgnoreCase("s")) {
                String nuevoNombre = Util.getLine("Nuevo nombre: ");
                cliente.setNombre(nuevoNombre);
            }
            System.out.println("Nombre: " + cliente.getNombre());
            if (Util.getLine("¿Desea cambiar el nombre? (s/n): ").equalsIgnoreCase("s")) {
                String nuevoNombre = Util.getLine("Nuevo nombre: ");
                cliente.setNombre(nuevoNombre);

                boolean actualizado = clienteController.update(cliente);
                System.out.println(actualizado ? "Cliente actualizado exitosamente." : "Error al actualizar cliente.");

            } else {
                System.out.println("Cliente no encontrado");
            }

        }

    }

    @Override
    public void eliminar() {
        String id = Util.getLine("Ingrese el ID del cliente a eliminar:");
        Cliente cliente = clienteController.search(id);

        if (cliente != null) {
            boolean eliminado = clienteController.delete(cliente);
            System.out.println(eliminado ? "Cliente eliminado exitosamente." : "No se pudo eliminar el cliente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }

    }
}
