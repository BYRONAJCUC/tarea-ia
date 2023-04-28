/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividadenclase.busqueda;

/**
 *
 * @author miguelcatalan
 */
public class ActividadEnClaseBusqueda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Laberinto g = new Laberinto(4);
        
        g.agregarBorde(1, 1);
        g.agregarBorde(2, 2);
        g.agregarBorde(2, 3);
        g.agregarBorde(3, 2);
 
        System.out.println( "Recorrido en Anchura (Iniciando  con vertice 2)");
 
        g.BreadthFirstSearch(2);
    }
    
}
