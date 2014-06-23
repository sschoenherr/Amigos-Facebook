/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Amigos;

import java.util.ArrayList;

/**
 *
 * @author stephanie
 */
public class Nodo {
    private int id;
    private String nombre;
    private Nodo siguiente;
   
    public boolean visitado = false;// define un parametro del tipo booleano para la marca visitado

    public Nodo(){// prepara espacio para el nodo
    	
    }
    
    public Nodo(int id, String nombre){
       this.id=id;
       this.nombre=nombre;
       this.siguiente=null;
    }
    
    public Nodo(int id){
       this.id=id;
       this.nombre="";
       
       this.siguiente=null;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " "+ "NOMBRE: " + nombre;
    }
    
    public String toString2(){
        return "ID: " + id;
    }
   
}
