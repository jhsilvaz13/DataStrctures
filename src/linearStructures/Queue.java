/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
public class Queue<T> extends LinkedList<T>{
    public Queue(){
        super();
    }
    //Encola un elemento(al final de lista enlazada)
    public void Enqueue(Node<T> node){
        pushBack(node);
    }
    //Desencola un elemento(al inicio de lista enlazada)
    public Node<T> Dequeue() {
        Node <T> dequeueNode=getBeginNode();
        popFront();
        return dequeueNode;
    }
    
}
