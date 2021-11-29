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
    //Agrega al inicio de la lita(final de la pila)
    public void push(Node<T> newNode){
        pushFront(newNode);
    }
    
    //Eliminar al inicio de la lista(final de la pila)
    public void  pop(){
       popFront();
    }
    
    //Retorna el elemento que se añadio de ultimas, despues lo elmina
    public Node<T> peek(){
        Node<T> node=getBeginNode();
        pop();
        return node;
    }
    
    //Retorna el ultimo elemento añadido pero no lo elimian
    public Node<T> top(){
        return  getBeginNode();
    }
}
