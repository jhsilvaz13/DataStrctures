/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
public class DoubleLinkedList<T> {

    Node<T> beginNode, lastNode;

    public DoubleLinkedList() {
        this.beginNode = this.lastNode = null;
    }

    public DoubleLinkedList(Node<T> beginNode) {
        this.beginNode = this.lastNode = beginNode;
    }

    //Agrega un elemento al final de la lista
    public void pushBack(Node<T> newNode) {
        if (isEmpty()) {
            this.beginNode = this.lastNode = newNode;
        } else {
            this.lastNode.nextNode = newNode;
            this.lastNode.nextNode.beforeNode = lastNode;
            this.lastNode = newNode;
        }

    }

    //Eliminar un elemento al final
    public void popBack() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            this.lastNode = this.lastNode.beforeNode;
            this.lastNode.nextNode = null;
        }
    }

    //Añadir un elemento al inicio de la lista
    public void pushFront(Node<T> newNode) {
        if (isEmpty()) {
            this.beginNode = this.lastNode = newNode;
        } else {
            this.beginNode.beforeNode = newNode;
            newNode.nextNode = beginNode;
            beginNode = newNode;
        }
    }

    //Eliminar un ellemento al inicio
    public void popFront() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        }else if(beginNode==lastNode){
            beginNode=lastNode=null;
        } 
        else {
            beginNode = beginNode.nextNode;
            beginNode.beforeNode=null;
        }
    }

    //Retorna si la lista es vacia
    public boolean isEmpty() {
        if (beginNode == null && lastNode == null) {
            return true;
        }
        return false;
    }

    //Retrona el ultimo nodo sin eliminarlo
    public Node<T> topBack() {
        return this.lastNode;
    }

    //Retorna el primer nodo sin eliminarlo
    public Node<T> topFront() {
        return this.beginNode;
    }

    //Busca si algun nodo contiene el elemento K
    public boolean find(T k) {
        if (!isEmpty()) {
            Node<T> iterator = beginNode;
            while (iterator != null) {
                if (iterator.data.equals(k)) {
                    return true;
                }
                iterator = iterator.nextNode;
            }
            return false;
        } else {
            return false;
        }
    }

    //Añadir un nuevo nodo antes de node con el dato data
    public void addBefore(Node<T> node, T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            pushBack(newNode);
        } else {
            if (node.beforeNode != null) {
                newNode.beforeNode = node.beforeNode;
                newNode.nextNode = node;
                node.beforeNode = newNode;
                newNode.beforeNode.nextNode = newNode;
            } else {
                pushFront(newNode);
            }
        }
    }

    //Añade un nuevo nodo con data despues de node
    public void addAfter(Node<T> node, T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            pushBack(newNode);
        } else {

            if (node.nextNode != null) {
                newNode.nextNode = node.nextNode;
                newNode.beforeNode = node;
                node.nextNode = newNode;
                newNode.nextNode.beforeNode = newNode;
            } else {
                pushBack(newNode);
            }
        }
    }
    
        public Node<T> getBeginNode() {
        return this.beginNode;
    }

    public Node<T> getLastNode() {
        return this.lastNode;
    }

    //imprimir la lista de inicio a fin
    public void print() {
        if (beginNode != null) {
            Node<T> iterator = beginNode;
            System.out.print(iterator.data + " ");
            while (iterator.nextNode != null) {
                iterator = iterator.nextNode;
                System.out.print(iterator.data + " ");
            }
            System.out.println();
        }
    }
    
    public void printR() {
        if (lastNode != null) {
            Node<T> iterator = lastNode;
            System.out.print(iterator.data + " ");
            while (iterator.beforeNode != null) {
                iterator = iterator.beforeNode;
                System.out.print(iterator.data + " ");
            }
            System.out.println();
        }
    }
}
