/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
import java.util.Scanner;
public class tarea1ListasSecuenciales {
    public static void main(String[] args) {
        
        Scanner in= new Scanner(System.in);
        String palabra=in.nextLine();
        punto1(palabra);

    }
    
    public static void punto1(String palabra){
        DoubleLinkedList<Character> listaEnlazada=new DoubleLinkedList<>(new Node<Character>(palabra.charAt(0)));
        for(int i=1; i<palabra.length();i++){
            listaEnlazada.pushBack(new Node<Character>(palabra.charAt(i)));
        }
        
        listaEnlazada.removeRepeats();
        System.out.println(listaEnlazada.getBeginNode().data+"/"+listaEnlazada.getLastNode().data);
        listaEnlazada.printLinkedList();
    }
     public static  void punto2(String palabra){
        
    }
}
