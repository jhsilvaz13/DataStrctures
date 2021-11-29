package linearStructures;

/**
 *
 * @author jhonz
 */
public class LinkedList<T> {

    private Node<T> beginNode, lastNode;

    public LinkedList() {
        this.beginNode = this.lastNode = null;
    }

    public LinkedList(Node<T> beginNode) {
        this.beginNode = this.lastNode = beginNode;
    }

    //Agrega un elemento al final de la lista
    public void pushBack(Node<T> newNode) {
        if (this.beginNode == null) {
            this.beginNode = this.lastNode = newNode;
        } else {
            this.lastNode.nextNode = newNode;
            this.lastNode = newNode;
        }
    }

    //Eliminar un elemento al final de la lista
    public void popBack() {
         if(beginNode==null){
            System.out.println("La lista esta vacia");
        }else if(beginNode==lastNode){
            this.beginNode=this.lastNode=null;
        }else{
            Node<T> lastB = beginNode;
            while (lastB.nextNode.nextNode != null) {
                lastB = lastB.nextNode;
            }
            lastB.nextNode = null;
            lastNode = lastB;
        }
    }

    //Agregar elemento al inicio de la lista
    public void pushFront(Node<T> newNode) {
        if (this.beginNode == null) {
            this.beginNode = this.lastNode = newNode;
        } else {
            newNode.nextNode = this.beginNode;
            this.beginNode = newNode;
        }
    }

    //Eliminar un elemento al inicio de la lista
    public void popFront() {
        try {
            this.beginNode = this.beginNode.nextNode;
        } catch (Exception exc) {
            System.out.println("--La lista está vacia--");
        }
    }

    //Imprime la lista enlazada desde la cabeza
    public void print() {
        if (this.beginNode != null) {
            Node<T> iterator = beginNode;
            System.out.print(iterator.data + " ");
            while (iterator.nextNode != null) {
                iterator = iterator.nextNode;
                System.out.print(iterator.data + " ");
            }
            System.out.println();
        }else{
            System.out.println();
        }
    }

    //Añadir un nodo nuevo despues de de node
    public void addAfter(Node<T> node, T data) {
        Node<T> newNode = new Node<T>(data);
        if (node.nextNode != null) {
            newNode.nextNode = node.nextNode;
            node.nextNode = newNode;
        } else {
            pushBack(newNode);
        }
    }
    //Agrega al final de la lista otra lista

    public void mergeEnd(LinkedList<T> secondLinkedList) {
        pushBack(secondLinkedList.beginNode);
    }

    public void sortList() {
        Node<T> iNode = this.getBeginNode();
        Node<T> jNode;
        while (iNode != null) {
            jNode = this.getBeginNode();
            while (jNode.nextNode != null) {
                if ((Integer) jNode.data > (Integer) jNode.nextNode.data) {
                    T temp = jNode.data;
                    jNode.data = jNode.nextNode.data;
                    jNode.nextNode.data = temp;
                }
                jNode = jNode.nextNode;
            }
            iNode = iNode.nextNode;
        }
    }

    //Elimina datos repetidos que esten consecutivos o en una lista ordenada
    public void removeRepeats() {
        Node<T> iterator = beginNode;
        while (iterator.nextNode != null) {
            if (iterator.data == iterator.nextNode.data) {
                if (iterator.nextNode.nextNode != null) {
                    Node<T> aux = iterator.nextNode;
                    iterator.nextNode = aux.nextNode;
                } else {
                    popBack();
                }
            } else {
                iterator = iterator.nextNode;
            }
        }
    }

    public Node<T> getBeginNode() {
        return this.beginNode;
    }

    public Node<T> getLastNode() {
        return this.lastNode;
    }
}
