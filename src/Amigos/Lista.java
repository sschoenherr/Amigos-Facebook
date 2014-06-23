/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amigos;

/**
 *
 * @author stephanie
 */
public class Lista {

    private Nodo cabeza;
    private Nodo ultimo;
    int cant = 0;

    public int getID() {
        return cabeza.getId();
    }

    public String getNombre() {
        return cabeza.getNombre();
    }

    public Lista() {
    }

    public Lista(int id, String nombre) {
        this.cabeza = new Nodo(id, nombre);
        this.ultimo = cabeza;
        cant = 1;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    void addArista(int id) {
        ultimo.setSiguiente(new Nodo(id));
        ultimo = ultimo.getSiguiente();
        cant++;
    }

    public int getSize(){
        return cant;
    }
    
    public void imprimir() {
        Nodo tmp = cabeza;
        System.out.println(tmp.toString());
        if (tmp.getSiguiente() != null) {
            tmp = tmp.getSiguiente();
            while (tmp.getSiguiente() != null) {
                System.out.print (tmp.toString2() + " ");
                tmp = tmp.getSiguiente();
            }
            System.out.println( tmp.toString2() + " " );
        }
    }

    
    
    public boolean Visitado() {
        return cabeza.isVisitado();
    }

    public void visitar() {
        cabeza.setVisitado(true);
    }
}
