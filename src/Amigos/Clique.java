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
public class Clique extends ArrayList<Nodo>{
    
    Clique(Nodo nodoInicial){
        super();
        this.add(nodoInicial);
    }
    
    public int getTamano(){
        return this.size();
    }
    
    public void agregarNodo(Nodo n){
        this.add(n);
    }
    
    public void imprimir(){
        String cliqueString = "{";
        for(int i = 0; i < this.size(); i++){
           cliqueString += this.get(i).getId()+",";
        }
        cliqueString += "}";
        System.out.println(cliqueString);
    }
}
