/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmosjava;

/**
 *
 * @author Gollo
 */
public class Nodo {
    
    private Pelicula pelicula;
    private Nodo nextPtr;
    private Nodo previousPtr;
    
    public Nodo(){
        this.pelicula=null;
        this.nextPtr=null;
        this.previousPtr=null;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Nodo getNextPtr() {
        return nextPtr;
    }

    public void setNextPtr(Nodo nextPtr) {
        this.nextPtr = nextPtr;
    }

    public Nodo getPreviousPtr() {
        return previousPtr;
    }

    public void setPreviousPtr(Nodo previousPtr) {
        this.previousPtr = previousPtr;
    }
    
    
}// Nodo
