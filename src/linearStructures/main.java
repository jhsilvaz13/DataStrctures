/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jhonz
 */
public class main {

    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        //linkedList();
        //punto2UNCODE();
        Stacks();
    }
    
    public static void linkedList0() {
        LinkedList0<Integer> beginNode = new LinkedList0<>(3);
        LinkedList0<Integer> secondNode = new LinkedList0<>(12);
        LinkedList0<Integer> thirdNode = new LinkedList0<>(4);
        LinkedList0<Integer> fourthNode = new LinkedList0<>(2);
        LinkedList0<Integer> fifthNode = new LinkedList0<>(24);
        beginNode.nextNode = secondNode;
        secondNode.nextNode = thirdNode;
        thirdNode.nextNode = fourthNode;
        fourthNode.nextNode = fifthNode;
        //search element O(k)
        System.out.println(beginNode.search(1000));
        beginNode.printLinkedList();
        //add element
        LinkedList0<Integer> aux = thirdNode;
        LinkedList0<Integer> intermedio = new LinkedList0<>(9999);
        secondNode.nextNode = intermedio;
        intermedio.nextNode = aux;
        beginNode.printLinkedList();
        //popElement
        intermedio.nextNode = null;
        intermedio.nextNode = fourthNode;
        beginNode.printLinkedList();

    }

    public static void linkedList() {
        LinkedList<Integer> linkedLista;
        linkedLista = new LinkedList<>();
        linkedLista.pushBack(new Node<Integer>(11));
        linkedLista.pushBack(new Node<Integer>(12));
        linkedLista.pushBack(new Node<Integer>(13));
        linkedLista.pushBack(new Node<Integer>(14));
        linkedLista.pushBack(new Node<Integer>(15));
        linkedLista.pushBack(new Node<Integer>(16));
        linkedLista.pushFront(new Node<Integer>(10));
        linkedLista.pushFront(new Node<Integer>(9));
        linkedLista.pushFront(new Node<Integer>(8));
        linkedLista.pushFront(new Node<Integer>(7));
        linkedLista.popBack();

        linkedLista.popBack();
        linkedLista.popBack();
        linkedLista.print();

    }

    public static void Stacks() {
        Stack<Integer> s = new Stack<>();
        s.push(new Node<Integer>(10));
        s.push(new Node<Integer>(11));
        s.push(new Node<Integer>(12));
        s.push(new Node<Integer>(13));

        s.print();
    }

    public static void Queue() {
        Queue<Integer> cola=new Queue<Integer>();
        cola.Enqueue(new Node<Integer>(10));
        cola.Enqueue(new Node<Integer>(11));
        cola.Enqueue(new Node<Integer>(12));
        cola.Enqueue(new Node<Integer>(13));
        Node<Integer> data=cola.Dequeue();
        System.out.println(data.data);
        cola.print();
    }
    
    public static void Double() {
        DoubleLinkedList<Integer> d=new DoubleLinkedList<Integer>();
        d.pushFront(new Node<Integer>(10));
        
        System.out.println(d.find(-10));
        d.addBefore(d.beginNode,55);
        d.print();

    }
    public static void dinamicA() {
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(2);
        a.print();
        a.add(3);
        a.print();
        a.add(4);
        a.print();
        a.add(5);
        a.print();
        a.add(6);
        a.print();
        a.add(7);
        a.print();
        a.add(8);
        a.print();
        a.add(9);
        a.print();
        System.out.println(a.getN()+"/"+a.getLen());
    }
    public static LinkedList<Integer> readInput(int len) {
        LinkedList<Integer> input = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            int a = IN.nextInt();
            input.pushBack(new Node<Integer>(a));
        }
        return input;
    }

    public static void punto1UNCODE() {
        int cases = IN.nextInt();
        for (int i = 0; i < cases; i++) {
            int n, m;
            LinkedList<Integer> nLink, mLink;
            //Lectura de datos de entrada
            n = IN.nextInt();
            nLink = readInput(n);
            m = IN.nextInt();
            mLink = readInput(m);

            if (n != 0 && m != 0) {
                nLink.mergeEnd(mLink);
                nLink.sortList();
                nLink.removeRepeats();
                nLink.print();
            } else {
                if (n == 0) {
                    mLink.sortList();
                    mLink.removeRepeats();
                    mLink.print();
                } else {
                    nLink.sortList();
                    nLink.removeRepeats();
                    nLink.print();
                }
            }
            if(i+1!=cases){
                 System.out.println();
             }
        }
        IN.close();
    }

    private static void punto2UNCODE() {
        int n=IN.nextInt();
        Integer operaciones[]=new Integer[n];
        Integer parametros[]=new Integer[n];

        for(int i=0; i<n;i++){
            int op=IN.nextInt();
            operaciones[i]=op;
            if(op==1 || op==2 || op==3){
               parametros[i]=IN.nextInt();
            }
        }
        IntegerContainer contenedor=new IntegerContainer(operaciones,parametros);
        contenedor.solucion();
        
    }
}
