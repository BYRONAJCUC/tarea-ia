/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividadenclase.busqueda;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author miguelcatalan
 */
public class Laberinto {
    public final short OBSTACULO = -1;
    private short INICIO = -2;
    private static short OBJETIVO = -3;
    private int alto = 3;
    private int largo = 3;
    
    // No. de vertices
    private int V;
 
    // Lista de adyacentes
    private LinkedList<Integer> adj[];

    private short [][] laberinto;
    
    // Constructor
    Laberinto(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i){
            adj[i] = new LinkedList();
        }
            
        
    }
    
    // Función para agregar un borde en el gráfico
    void agregarBorde(int v, int w) { adj[v].add(w); }
    
    public Laberinto() {
        System.out.println("Nuevo laberinto de tamaño: " + alto + " por " + largo);
        
        laberinto = new short[largo + 2][alto + 2];
        
        for (int i = 0; i< largo + 2; i++) {
            for (int j = 0; j < alto + 2; j++) {
                laberinto[i][j] = 0;
            }
        }
        
        for (int i = 0; i < alto + 2; i++) {
            laberinto[0][i] = laberinto[largo + 1][i] = OBSTACULO;
        }
        
        for (int i = 0; i < largo + 2; i++) {
            laberinto[i][0] = laberinto[i][alto + 1] = OBSTACULO;
        }
        
        //Colocar obstaculos
        setValor(1, 2, OBSTACULO);
        setValor(2, 2, OBSTACULO);
        setValor(2, 3, OBSTACULO);
        
        //Especificar el estado inicial
        setValor(1, 1, (short)0);
        
        //Especifiar el estado objetivo
        setValor(largo - 1, alto - 1, OBJETIVO);
    }
    
    public short getValor(int x, int y) { 
        return laberinto[x + 1][y + 1]; 
    }
    
    public void setValor(int x, int y, short value) { 
        laberinto[x + 1][y + 1] = value; 
    }
    
    public int getLargo() { 
        return largo; 
    }
    
    public int getAlto() { 
        return alto; 
    }
    
    // Recorrido BFS de una fuente dada s
    void BreadthFirstSearch(int s)
    {
        // Marcar todos los vértices como no visitados (Por defecto se establece como falso)
        boolean visitado[] = new boolean[V];
 
        // Crear una cola para BFS
        LinkedList<Integer> cola = new LinkedList<Integer>();
 
        // Marcar el nodo actual como visitado y ponerlo en cola
        visitado[s] = true;
        cola.add(s);
 
        while (cola.size() != 0) {
             
            // Retirar un vértice de la cola e imprimirlo
            s = cola.poll();
            System.out.print(s + " ");
 
            // Obtener todos los vértices adyacentes de los vértices eliminados si no se ha visitado un adyacente,
            // luego marcarlo como visitado y ponerlo en cola
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visitado[n]) {
                    visitado[n] = true;
                    cola.add(n);
                }
            }
        }
    }
}