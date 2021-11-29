/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
public class Node<T> {
    T data;
    Node<T> nextNode;
    Node<T> beforeNode;
    public Node(T data){
        this.data=data;
        this.nextNode=null;
        this.beforeNode=null;
    }
    public void setData(T data){
        this.data=data;
    }
}
