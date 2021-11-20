/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
public class DoubleLinkedList<T>{
    Node<T> beginNode, lastNode;
    public DoubleLinkedList(Node<T> beginNode){
        this.beginNode=this.lastNode=beginNode;
    }
    
    //Agrega un elemento al final de la lista
    public void pushBack(Node<T> newNode){
        this.lastNode.nextNode=newNode;
        this.lastNode.nextNode.beforeNode=lastNode;
        this.lastNode=newNode;
    }
    
    public Node<T> getBeginNode(){
        return this.beginNode;
    }
    
    public Node<T> getLastNode(){
        return this.lastNode;
    }
    //Eliminar un elemento al inicio
    public void popFront(){
        this.beginNode=this.beginNode.nextNode;
        this.beginNode.beforeNode=null;
    }
    //Eliminar un elemento al final
    public void popBack(){
        this.lastNode=this.lastNode.beforeNode;
        this.lastNode.nextNode=null;
    }
    //imprimir la lista de inicio a fin
    public void printLinkedList(){
        Node<T> iterator=beginNode;
        System.out.println(iterator.data);
        while(iterator.nextNode!=null){
            iterator=iterator.nextNode;
            System.out.println(iterator.data);
        }   
    }
    //imprimir la lista de fin a inicio
    public void printLinkedListR(){
        Node<T> iterator=lastNode;
        System.out.println(iterator.data);
        while(iterator.beforeNode!=null){
            iterator=iterator.beforeNode;
            System.out.println(iterator.data);
        }   
    }
    //Eliminar el siguiente nodo a node
    public void eraseNextNode(Node<T> node){
        if(node.nextNode.nextNode!=null){
            Node<T> aux=node.nextNode;
            node.nextNode=null;
            node.nextNode=aux.nextNode;
            node.nextNode.beforeNode=node;
            }else{
                popBack();
        }
    }
    public void eraseNowNode(Node<T> node){
        if(node.nextNode==null){
            Node<T> aux=node;
            node.beforeNode=node.nextNode;
            node.nextNode.beforeNode=aux.beforeNode;
            node=null;
        }else{
            popBack();
        }
    }
    //eliminar repetidos
    public void removeRepeats(){
        Node<T> i=beginNode;
        while(i.nextNode!=null){
            Node<T> j=i;
            while(j.nextNode!=null){
                if(j.nextNode.data==i.data){
                    eraseNextNode(j);
                }else{
                    j=j.nextNode;
                }
            }
            if(i.nextNode!=null){
                i=i.nextNode;
            }
        }
    }
}
