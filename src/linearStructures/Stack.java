/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
public class Stack<T> extends LinkedList<T>{
    public Stack(){
        super();
    }
    //Agrega al inicio de la lita(final de la cola)
    public void push(Node<T> newNode){
        pushFront(newNode);
    }
    
    //Eliminar al inicio de la lista(final de la pila)
    public void  pop(){
       popFront();
    }
    
    //No se puede eliminar al inicio de una pila
    @Override
    public void popBack() {
    }

    //No se puede agregar al inicio de una pila
    @Override
    public void pushBack(Node<T> newNode) {
    }

    @Override
    public void print(){
        super.print(); //To change body of generated methods, choose Tools | Templates.
    }
}
