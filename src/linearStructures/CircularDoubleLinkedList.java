/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
public class CircularDoubleLinkedList<T> {

    Node<T> beginNode;

    public CircularDoubleLinkedList() {
        this.beginNode = null;
    }

    public CircularDoubleLinkedList(Node<T> beginNode) {
        this.beginNode = beginNode;
        this.beginNode.beforeNode = beginNode;
        this.beginNode.nextNode = beginNode;
    }

    //Agrega un elemento al final de la lista
    public void pushBack(Node<T> newNode) {
        if (isEmpty()) {
            this.beginNode = newNode;
            this.beginNode.beforeNode = beginNode;
            this.beginNode.nextNode = beginNode;
        } else {
            Node<T> aux = this.beginNode.beforeNode;
            aux.nextNode = newNode;
            newNode.beforeNode=aux;
            this.beginNode.beforeNode=newNode;
            newNode.nextNode = beginNode;

        }

    }

    public void print() {
        if (beginNode != null) {
            Node<T> iterator = beginNode;
            System.out.print(iterator.data);
            while (iterator.nextNode != beginNode) {
                iterator = iterator.nextNode;
                System.out.print(" "+iterator.data);
            }
            System.out.println();
        }
    }
    
    //Retorna si la lista es vacia
    public boolean isEmpty() {
        if (beginNode == null) {
            return true;
        }
        return false;
    }
}
