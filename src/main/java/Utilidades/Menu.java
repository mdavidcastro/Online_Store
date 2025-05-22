
package Utilidades;

import java.util.ArrayList;

/**
 * Clase Menu para generar menús interactivos en la consola.
 * 
 * Esta clase permite mostrar opciones en un formato visual centrado, con caracteres de relleno,
 * y capturar la selección del usuario. Es útil para sistemas de consola que requieren menús
 * estructurados y fáciles de navegar.
 * 
 * Características principales:
 * - Las opciones del menú se alinean centradas con caracteres de relleno.
 * - Se agrega un número al final de cada opción para permitir la selección.
 * - Incluye una opción de "Salir" con el valor 0.
 * - Valida que la entrada del usuario sea un número dentro del rango de opciones disponibles.
 * 
 * Ejemplo de uso:
 * <pre>
 *     String[] opciones = { "Menú Principal", "Opción 1", "Opción 2", "Opción 3" };
 *     Menu menu = new Menu(opciones);
 *     int opcionSeleccionada = menu.create();
 * </pre>
 * 
 * @author Profesor
 */
public class Menu {

    private int length = 60; // Longitud total de la línea del menú
    private String charSet = "."; // Caracter para rellenar las líneas del menú
    private String[] opciones; // Opciones del menú

    /**
     * Constructor de la clase Menu.
     * 
     * @param opciones Un arreglo de cadenas que representan las opciones del menú.
     *                 La primera opción se usará como título.
     */
    public Menu(String[] opciones) {
        this.opciones = opciones;
    }

    /**
     * Obtiene la longitud total del menú.
     * 
     * @return La longitud total (número de caracteres) de las líneas del menú.
     */
    public int getLength() {
        return length;
    }

    /**
     * Establece la longitud total del menú.
     * 
     * @param length La nueva longitud total (número de caracteres) de las líneas del menú.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Obtiene el carácter utilizado para rellenar las líneas del menú.
     * 
     * @return El carácter de relleno como cadena.
     */
    public String getCharSet() {
        return charSet;
    }

    /**
     * Establece el carácter utilizado para rellenar las líneas del menú.
     * 
     * Solo se utiliza el primer carácter de la cadena proporcionada.
     * 
     * @param charSet La nueva cadena que contiene el carácter de relleno.
     */
    public void setCharSet(String charSet) {
        this.charSet = String.valueOf(charSet.toCharArray()[0]);
    }

    /**
     * Crea y muestra el menú en la consola, capturando la opción seleccionada por el usuario.
     * 
     * El menú se muestra con las opciones alineadas y numeradas. También incluye una opción
     * adicional de "Salir" con el número 0. Valida que la entrada del usuario sea válida.
     * 
     * @return El número de la opción seleccionada por el usuario.
     *         Devuelve -1 si no hay opciones disponibles.
     */
    public int create() {
        // Validar que existan opciones
        if (opciones.length == 0) {
            System.out.println("No hay opciones disponibles.");
            return -1;
        }

        // Mostrar el título centrado
        int q = (length - opciones[0].length()) / 2;
        System.out.println(charSet.repeat(q) + opciones[0] + charSet.repeat(q));

        // Mostrar las opciones numeradas
        for (int i = 1; i < opciones.length; i++) {
            printOption(opciones[i], i);
        }

        // Mostrar la opción "Salir"
        printOption("Salir", 0);

        // Capturar y validar la opción seleccionada
        int opcion = -1;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        do {
            System.out.print("Digite una opción válida: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar entrada no válida
            }
            opcion = scanner.nextInt();
            if (opcion < 0 || opcion >= opciones.length) {
                System.out.println("Opción fuera de rango. Intente de nuevo.");
            }
        } while (opcion < 0 || opcion >= opciones.length);

        return opcion;
    }

    /**
     * Imprime una opción del menú con relleno ajustado.
     * 
     * @param texto El texto de la opción.
     * @param index El índice o número de la opción.
     */
    private void printOption(String texto, int index) {
        int q = length - (texto.length() + 1);
        System.out.println(texto + charSet.repeat(q) + index);
    }
}