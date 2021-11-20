/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 * @param <T>
 */
public class LinkedList0 <T>{
    LinkedList0<T>nextNode;
    T data;
  
    public LinkedList0(T data){
        this.data=data;
    }
    public boolean search(T data){
        if(this.data==data){
            return true;
        }else if(nextNode==null){
            return false;
        }else{
            return nextNode.search(data);
        }
    }
    
    public void printLinkedList(){
        System.out.println(this.data);
        if(this.nextNode!=null){
            nextNode.printLinkedList();
        }
    }
}
