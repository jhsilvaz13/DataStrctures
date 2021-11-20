/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

import java.util.Scanner;

/**
 *
 * @author jhonz
 */
public class main {

    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        punto1UNCODE();
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
        linkedLista.pushBack(new Node<Integer>(11));
        linkedLista.pushBack(new Node<Integer>(11));
        linkedLista.pushBack(new Node<Integer>(11));
        linkedLista.pushBack(new Node<Integer>(11));
        linkedLista.pushBack(new Node<Integer>(11));
        linkedLista.pushFront(new Node<Integer>(11));
        linkedLista.pushFront(new Node<Integer>(11));
        linkedLista.pushFront(new Node<Integer>(11));
        linkedLista.pushFront(new Node<Integer>(11));
        linkedLista.removeRepeats();
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

    public static LinkedList<Integer> readInput(int len) {
        LinkedList<Integer> input = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            int a = IN.nextInt();
            input.pushBack(new Node<Integer>(a));
        }
        return input;
    }
    public static LinkedList<Integer> mergeAndRemove(LinkedList<Integer> principalList, LinkedList<Integer> secondList) {
        Node<Integer> iterNode = principalList.getBeginNode();
        while (iterNode.nextNode != null && secondList.getBeginNode()!=null){
            if (secondList.getBeginNode().data > iterNode.data) {
                if(secondList.getBeginNode().data < iterNode.nextNode.data){
                    principalList.addAfter(iterNode, secondList.getBeginNode().data);
                    iterNode=iterNode.nextNode;
                    secondList.popFront();
                }else{
                    iterNode=iterNode.nextNode;
                }
            }else{
                secondList.popFront();
            }
        }
        if(secondList.getBeginNode()!=null){
            if(principalList.getLastNode().data==secondList.getBeginNode().data){
                secondList.popFront();
            }
            principalList.mergeEnd(secondList);
        }
        principalList.removeRepeats();
        return principalList;
    }

    public static void punto1UNCODE(){
        int cases = IN.nextInt();
        for (int i = 0; i < cases; i++) {
            int n, m;
            LinkedList<Integer> nLink, mLink;
            //Lectura de datos
            n = IN.nextInt();
            nLink = readInput(n);
            m = IN.nextInt();
            mLink = readInput(m);
            //Encontrar la lista principal(aquella con el primer menor elemento)
            if(n!=0 && m!=0){
                if (nLink.getBeginNode().data>=mLink.getBeginNode().data) {
                    mergeAndRemove(mLink, nLink).print();
                } else {
                    mergeAndRemove(nLink, mLink).print();
                }
            }else{
                if(n==0){
                    mLink.print();
                }else{
                    nLink.print();
                }
            }
        }
    }
}
