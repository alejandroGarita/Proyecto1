/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmosjava;

import javafx.scene.Node;

/**
 *
 * @author Gollo
 */
public class GeneroList {
    
    private Nodo headNode;
    
    public GeneroList(){
        this.headNode=null;
    }
    
    public int agregarPelicula(Pelicula nueva){
    Nodo tempPtr, newPtr;
    
    newPtr=new Nodo();
    newPtr.setPelicula(nueva);
    newPtr.setNextPtr(null);
    newPtr.setPreviousPtr(null);
    
    tempPtr=headNode;
    
    if(tempPtr==null){
        headNode=newPtr;
        newPtr.setNextPtr(headNode);
        newPtr.setPreviousPtr(headNode);
        return 0;
    }
    
    // falta ordenar por nombre con compare
    
    while(tempPtr.getNextPtr().getPelicula().getCode()!=headNode.getPelicula().getCode() ){
        if(tempPtr.getNextPtr().getPelicula().getCode()!=nueva.getCode())
            tempPtr=tempPtr.getNextPtr();
        else return -1;
    }
    
    tempPtr.setNextPtr(newPtr);
    newPtr.setNextPtr(headNode);
    headNode.setPreviousPtr(newPtr);
    newPtr.setPreviousPtr(tempPtr);
    return 0;
}// agregarPelicula
    
    public String printList(){
        Nodo tempNode=headNode;
        String lista="";
        if(tempNode!=null){
            while(tempNode!=null){
                lista+=tempNode.getPelicula().getCode()+"\t"+tempNode.getPelicula().getTitle()+"\n";
                tempNode=tempNode.getNextPtr();
                    if(tempNode.getPelicula().getCode()==headNode.getPelicula().getCode()){
                        lista+="";
                        return lista;
                    }
                
            }
        }else{
            return "The list is empty.\n\n";
        }
        return "";
    }// printList
    
    void printListReverse(){
        Nodo tempNode=headNode;

        if(tempNode!=null){
            System.out.print(tempNode.getPelicula().getTitle()+"-->");
                tempNode=tempNode.getPreviousPtr();
            while(tempNode.getPelicula().getCode()!=headNode.getPelicula().getCode()){
                System.out.print(tempNode.getPelicula().getTitle()+"-->");
                tempNode=tempNode.getPreviousPtr();
            }
            System.out.print("HEAD\n\n");
        }else{
            System.out.print("The list is empty.\n\n");
        }
    }// printListReverse
    
    public GeneroList buscarPelicula(String nombre){
        GeneroList resultado=new GeneroList();
        
        Nodo tempPtr=headNode;
        
        if(tempPtr==null)
            return resultado;
        if(tempPtr.getPelicula().getTitle().equals(nombre)){
            resultado.agregarPelicula(tempPtr.getPelicula());
            tempPtr=tempPtr.getNextPtr();
        }else tempPtr=tempPtr.getNextPtr();
        while(tempPtr.getPelicula().getCode()!=headNode.getPelicula().getCode()){
            if(tempPtr.getPelicula().getTitle().equals(nombre)){
                resultado.agregarPelicula(tempPtr.getPelicula());
                tempPtr=tempPtr.getNextPtr();
            }else tempPtr=tempPtr.getNextPtr();
        }
 
        return resultado;
    }// buscarPelicula
    
    public int size(){
        Nodo tempPtr=headNode;
        int cont=0;
        
        if(tempPtr!=null){
            cont++;
            tempPtr=tempPtr.getNextPtr();
            while(tempPtr.getPelicula().getCode().equals(headNode.getPelicula().getCode())!=true){
                cont++;
                tempPtr=tempPtr.getNextPtr();
            }
        }
        return cont;
    }
    
    public Pelicula get(int i){
        Nodo tempPtr=headNode;
        int cont=0;
        
        if(tempPtr!=null){
            if(i==cont){
                return tempPtr.getPelicula();
            }else{
                cont++;
                tempPtr=tempPtr.getNextPtr();
                while(tempPtr.getPelicula().getCode().equals(headNode.getPelicula().getCode())!=true){
                    if(i==cont){
                        return tempPtr.getPelicula();
                    }else{
                        cont++;
                        tempPtr=tempPtr.getNextPtr();
                    }
                }
            }
        }
        
        return tempPtr.getPelicula();
    }
    
}// GeneroList
