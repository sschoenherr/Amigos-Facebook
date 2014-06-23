/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amigos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stephanie
 */
public class Grafo {

    private ArrayList<Lista> Grafo;
    private ArrayList<Nodo> lista2 = new ArrayList();
    private ArrayList<String> setcover = new ArrayList();
    private ArrayList<Nodo>puntoart= new ArrayList();

    public Grafo() {
        Grafo = new ArrayList<Lista>();
    }

    public Grafo(ArrayList<Lista> Grafo) {
        this.Grafo = Grafo;
    }

    public void AgregarNodo(int id, String nombre) {
        Grafo.add(new Lista(id, nombre));

    }

    public void AgregarArista(int id, int id2) {
        for (int i = 0; i < Grafo.size(); i++) {
            if (Grafo.get(i).getID() == id) {
                Grafo.get(i).addArista(id2);
            }
        }
    }

    public void AgregarAristaDirigida(int id, int id2){
           AgregarArista(id,id2);
           AgregarArista(id2,id);
    }
    
    public void imprimirGrafo() {
        for (int i = 0; i < Grafo.size(); i++) {
            Grafo.get(i).imprimir();

        }
    }

    public void recorrido() {
        for (int i = 0; i < Grafo.size(); i++) {
            Nodo tmp = Grafo.get(i).getCabeza();
            if (!estaVisitado(tmp.getId())) {
                bfp(tmp);
            }
        }
    }
    
    public void limpiarGrafo(){
        for (int i = 0; i <Grafo.size(); i++) {
            Nodo tmp = Grafo.get(i).getCabeza();
            if(estaVisitado(tmp.getId()))
                tmp.setVisitado(false);
            
        }
    }
    
   

    private void bfp(Nodo valor) {
        lista2.add(valor);
        visitar(valor.getId());
        do {
            valor = valor.getSiguiente();
            if (valor != null && !estaVisitado(valor.getId())  ) {
                bfp(Grafo.get(obtenerLista(valor.getId())).getCabeza());
            }
        } while (valor != null && valor.getSiguiente() != null);
    }

    private int obtenerLista(int id) {
        for (int i = 0; i < Grafo.size(); i++) {
            if (Grafo.get(i).getID() == id) {
                return i;
            }
        }
        return 0;
    }

    private Boolean estaVisitado(int id) {
        for (int i = 0; i < Grafo.size(); i++) {
            if (Grafo.get(i).getID() == id) {
                return Grafo.get(i).Visitado();
            }
        }
        return true;
    }

    private void visitar(int id) {
        for (int i = 0; i < Grafo.size(); i++) {
            if (Grafo.get(i).getID() == id) {
                Grafo.get(i).visitar();
            }
        }
    }

    public void imprimirRecorrido() {
        for (int i = 0; i < lista2.size(); i++) {
            System.out.println(lista2.get(i).toString());
        }
    }

    public void SetCover() {
        int cont = 0;
        int[] Acont;
        for (int i = 0; i < Grafo.size(); i++) {
            Nodo tmp = Grafo.get(i).getCabeza();
            Acont = new int[Grafo.get(i).getSize()];
            cont = 0;
            while (tmp.getSiguiente() != null) {
                if (!estaIngresado(tmp.getId())) {
                    Acont[cont] = tmp.getId();
                    cont++;
                }
                tmp = tmp.getSiguiente();
            }

            if (!estaIngresado(tmp.getId())) {
                Acont[cont] = tmp.getId();
                cont++;
            }
            if (cont / Grafo.get(i).getSize() * 100 >= 50 || cont > 1) {
                for (int j = 0; j < cont; j++) {
                    if (!estaIngresado(Acont[j])) {
                        setcover.add("" + Acont[j]);
                    }
                }
                puntoart.add(Grafo.get(i).getCabeza());
            }
        }

    }
    public void imprimirSetcover() {
        for (int i = 0; i < puntoart.size(); i++) {
            System.out.println(puntoart.get(i).toString());
        }
    }

    public boolean estaIngresado(int id) {
        for (int i = 0; i < setcover.size(); i++) {
            if (Integer.parseInt(setcover.get(i)) == id) {
                return true;
            }
        }
        return false;
    }
    
     public void Clique(){
        this.limpiarGrafo();
        ArrayList<Clique> todosCliques = new ArrayList<Clique>();
        Clique cliqueActual;
        for (int i = 0; i < Grafo.size(); i++) {
            Nodo tmp = Grafo.get(i).getCabeza();
            cliqueActual = new Clique(tmp);
            //Verificar que se pueda hacer clique
            while(tmp.getSiguiente() != null){
                tmp = tmp.getSiguiente();
                //Si el nodo tmp tiene una arista hacia TODOS los nodos en CliqueActual lo agregamos
                if(vaHaciaNodos(tmp,cliqueActual)){
                   cliqueActual.add(tmp);
                }
            }
            todosCliques.add(cliqueActual);
        }
        
        Clique cliqueMasGrande = todosCliques.get(0);
         for (int i = 0; i < todosCliques.size(); i++) {
             if(todosCliques.get(i).size() > cliqueMasGrande.size()){
                 cliqueMasGrande = todosCliques.get(i);
             }
         }
         
         System.out.println("EL clique mas grande es: ");
         cliqueMasGrande.imprimir();
    }
     
     public boolean vaHaciaNodos(Nodo nod,Clique clique){
         int cont=0;
         if( nod != null ){
            Lista listaN = Grafo.get(nod.getId() - 1);
            if(listaN.getCabeza().getId() == nod.getId()){

                for (int i = 0; i < clique.size(); i++) {
                    Nodo tmp = listaN.getCabeza();
                    while(tmp != null){
                       if(clique.get(i).getId() == tmp.getId()){
                           cont++;
                           break;
                       }  
                       tmp = tmp.getSiguiente();
                    }
                }
                if(cont==clique.size()){
                    return true;
                }
            }else{
                System.err.println("No es la lista que corresponde al nodo "+ nod.toString2());
            }
         }
         return false;
     }

    /* public void SetCover2(){
     int cont=0;
     int contnodos=0;
     double division=0;
     for (int i = 0; i < lista2.size(); i++) {
           
     Nodo tmp = lista2.get(i).getCabeza();
     cont=0;
     contnodos=0;

     while (tmp.getSiguiente() != null) {
     if (!estaVisitado(tmp.getId())) {
     visitar(tmp.getId());                  
     cont++;
     }
     contnodos++;
     tmp = tmp.getSiguiente();
                
     }
            
     if (!estaVisitado(tmp.getId())) {
     visitar(tmp.getId());
     cont++;
                
     }
     contnodos++;
            
     division=(cont/contnodos)*100;
     if(division>=50){
     setcover.add(new Lista(lista2.get(i).getID(),lista2.get(i).getNombre()));
     setcover.get(lista2.size() - 1).addArista(tmp.getId());
     }
     }
        
        
     }*/
}
