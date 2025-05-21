package interfaces;

import java.util.ArrayList;

/**
 * Interfaz para operaciones comunes de gestión de objetos.
 * 
 * Esta interfaz define métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * y otras operaciones comunes, como buscar y listar objetos.
 * 
 * @param <T> Tipo de objeto que será gestionado por las implementaciones de esta interfaz.
 */
public interface ICommonOperator<T> {
    
    /**
     * Ejecuta la lógica principal o flujo de operaciones.
     */
    void execute();

    boolean create(T obj);
    /**
     * Busca un objeto por su identificador único.
     * 
     * @param id El identificador único del objeto.
     * @return El objeto encontrado, o {@code null} si no existe.
     */
    T search(String id);

    /**
     * Obtiene una lista de todos los objetos en el sistema.
     * 
     * @return Una lista de todos los objetos.
     */
    ArrayList<T> toList();
   
    boolean update(T obj);

  
    boolean delete(T obj);

    /**
     * Encuentra el índice de un objeto en el sistema.
     * 
     * @param obj El objeto a buscar.
     * @return El índice del objeto, o -1 si no se encuentra.
     */
    int find(String id);

}