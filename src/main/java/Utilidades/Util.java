package Utilidades;
import java.util.Scanner;
/**
 * Clase Utilitaria para facilitar la interacción con la consola.
 * 
 * Esta clase incluye métodos estáticos para:
 * - Mostrar menús interactivos.
 * - Validar y capturar entrada de datos desde la consola (líneas de texto, números enteros y long).
 * 
 * Utiliza un único objeto {@link Scanner} para leer las entradas del usuario,
 * y proporciona validaciones para garantizar que los datos sean válidos antes de procesarlos.
 * 
 * También delega la creación de menús a la clase {@link Menu}.
 * 
 * Ejemplo de uso:
 * <pre>
 *     String nombre = Util.getLine("Ingrese su nombre:");
 *     int edad = Util.getInt("Ingrese su edad:");
 * </pre>
 * 
 * @author Profesor
 */
public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Muestra un menú interactivo basado en las opciones proporcionadas.
     * 
     * Este método delega la creación y manejo del menú a la clase {@link Menu}.
     * 
     * @param opciones Un arreglo de cadenas que representan las opciones del menú.
     * @return La opción seleccionada por el usuario (como un número entero).
     */
    public static int menu(String[] opciones) {
        Menu menu = new Menu(opciones);
        return menu.create();
    }

    /**
     * Solicita al usuario que ingrese una línea de texto.
     * 
     * Muestra un mensaje personalizado y captura la entrada del usuario.
     * 
     * @param msg El mensaje que se mostrará al usuario antes de capturar la entrada.
     * @return La línea de texto ingresada por el usuario.
     */
    public static String getLine(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    /**
     * Solicita al usuario que ingrese un número de tipo long.
     * 
     * Este método valida que la entrada sea un número válido de tipo long.
     * Si la entrada es inválida, solicita al usuario que intente nuevamente.
     * 
     * @param msg El mensaje que se mostrará al usuario antes de capturar la entrada.
     * @return El número de tipo long ingresado por el usuario.
     */
    public static long getLng(String msg) {
        System.out.println(msg);
        while (!scanner.hasNextLong()) {
            System.out.println("Entrada inválida. Digite un número válido:");
            scanner.next();
        }
        long value = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer
        return value;
    }

    /**
     * Solicita al usuario que ingrese un número entero.
     * 
     * Este método valida que la entrada sea un número válido de tipo int.
     * Si la entrada es inválida, solicita al usuario que intente nuevamente.
     * 
     * @param msg El mensaje que se mostrará al usuario antes de capturar la entrada.
     * @return El número entero ingresado por el usuario.
     */
    public static int getInt(String msg) {
        System.out.println(msg);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite un número válido:");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return value;
    }
}
