/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trees;

import linearStructures.Node;
import linearStructures.Queue;

/**
 *
 * @author jhonz
 */
public class BinarySearchTree<T extends Comparable<? super T>>{
    
    private class BinaryNode<T>{
        //Atributos Binary Node
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;
        
        //Constructores

        public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
       
    } 
    //Atributos Binary Search 
    private BinaryNode<T> root;
    
    //Constructores
    public BinarySearchTree() {
        root=null;
    }

    /*Metodos*/
    //Hacer vacio el arbol
    public void makeEmpty(){
        root=null;
    }
    
    //Verificar si el arbol esta vacio
    public boolean isEmpty(){
        return root==null;
    }
    
    //Inserta un nuevo nodo binario
    public void insert(T x){
        root=insert(x, root);
    }
    //Inserta recursivamente dependiendo si el nuevo dato es mayor o menor 
    //que el nodo actual
    private BinaryNode<T> insert(T x, BinaryNode<T> node){
        if(node==null){
            return new BinaryNode<T>(x, null, null);
        }
        //x es menor que el nodo actual
        if(x.compareTo(node.data)<0){
            node.left=insert(x, node.left);
        }
        //x es mayor que el nodo actual
        else if(x.compareTo(node.data)>0){
            node.right=insert(x, node.right);
        }
        return  node;
    }
    //Retorna si el arbol binario tiene el nodo que contiene a x
    public  boolean contains(T x){
        return  contains(x, root);
    }
    //Llama recursivamente para verifiicar si el nodo actual contiene a x
    //si no se va a la derecha o a la izquierda
    private boolean contains(T x, BinaryNode<T> node){
        if(node==null){
            return  false;
        }
        if(x.compareTo(node.data)<0){
            return contains(x, node.left);
        }else if(x.compareTo(node.data)>0){
            return contains(x, node.right);
        }else{
            return true;
        }
    }
    
    //Encontrar el minimo
    public T findMin(){
        if(this.isEmpty()){
            System.out.println("El arbol esta vacio");
        }else{
            return findMin(root).data;
        }
        return null;
    }
    
    //Recorrer recursivamente los hijos izquierdos
    private BinaryNode<T> findMin(BinaryNode<T> node){
        if(node.left==null){
            return node;
        }else{
            return findMin(node.left);
        }
    }
    
    //Encontrar el maximo
    public T findMax(){
        if(this.isEmpty()){
            System.out.println("El arbol esta vacio");
        }else{
            return findMax(root).data;
        }
        return null;
    }
    
    //Recorrer recursivamente los hijos derechos
    private BinaryNode<T> findMax(BinaryNode<T> node){
        if(node.right==null){
            return node;
        }else{
            return findMax(node.right);
        }
    }
    
    //Eliminar un nodo con el dato x
    public void remove(T x){
        root=remove(x, root);
    }
    
    //Elima recursivamente el nodo dependiendo si s una hoja, un nodo con un solo hijo o un nodo con dos hijos
    private BinaryNode<T> remove(T x, BinaryNode<T> node){
        if(this.isEmpty()){
            return node;
        }
        if(x.compareTo(node.data)<0){
            node.left=remove(x, node.left);
        }else if(x.compareTo(node.data)>0){
            node.right=remove(x, node.right);
        }else if(node.left!=null && node.right!=null){
            node.data=findMin(node.right).data;
            node.right=remove(node.data, node.right);
        }else{
            node=(node.left!=null)?node.left:node.right;
        }
        return node;
    }
    
    
    //Retorna la altura maxima desde la raiz
    public int height(){
        return height(root);
    }
    
    //Calcula recursivamente la altura desde node
    private int height( BinaryNode<T> node )
    {
        return (node==null)?-1:1 + Math.max( height( node.left ), height( node.right ) );    
    }
    
    //Impresion preorden
    public void printPreorden(){
        printPreorden(root);
        System.out.println();
    }
    
    private void printPreorden(BinaryNode<T> node){
        if(node!=null){
            System.out.print(node.data+" ");
            printPreorden(node.left);
            printPreorden(node.right);
        }
    }
    
    //Impresion postorden
    public void printPostorden(){
        printPostorden(root);
        System.out.println();
    }
    
    private void printPostorden(BinaryNode<T> node){
        if(node!=null){
            printPostorden(node.left);
            printPostorden(node.right);
            System.out.print(node.data+" ");
        }
    }

    //Impresion inorden
    public void printInorden(){
        printInorden(root);
        System.out.println(); 
    }
    
    private void printInorden(BinaryNode<T> node){
        if(node!=null){
            printInorden(node.left);
            System.out.print(node.data+" ");
            printInorden(node.right);
        }
    }
    
    //Impresion por niveles
    public void printNiveles(){
        printNiveles(root);
        System.out.println();
    }
    private void printNiveles(BinaryNode<T> node){
        Queue<BinaryNode<T>> cola=new Queue<BinaryNode<T>>();
        cola.Enqueue(new Node<BinaryNode<T>>(node));
        while(!cola.isEmpty()){
            BinaryNode<T> aux=cola.Dequeue().getData();
            System.out.print(aux.data+" ");
            if(aux.left!=null){
                cola.Enqueue(new Node<BinaryNode<T>>(aux.left));
            }
            if(aux.right!=null){
                cola.Enqueue(new Node<BinaryNode<T>>(aux.right));
            }
        }
    }
}
