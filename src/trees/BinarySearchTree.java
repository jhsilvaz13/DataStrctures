/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trees;

/**
 *
 * @author jhonz
 */
public class BinarySearchTree<T extends Comparable<? super T>>{
    
    private class BinaryNode<T>{
        //Atributos Binary Node
        T data;
        BinaryNode<T> left;
        BinaryNode<T> rigth;
        
        //Constructores

        public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> rigth) {
            this.data = data;
            this.left = left;
            this.rigth = rigth;
        }
        

    } 
    //Atributos Binary Search Node
    private BinaryNode<T> root;
    
    //Constructores
    public BinarySearchTree() {
        root=null;
    }

    /*Metodos*/
    //Hace vacio el arbol
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
            return new BinaryNode<>(x, null, null);
        }
        //x es menor que el nodo actual
        if(x.compareTo(node.data)<0){
            node.left=insert(x, node.left);
        }
        //x es mayor que el nodo actual
        else if(x.compareTo(node.data)>0){
            node.rigth=insert(x, node.rigth);
        }
        return  node;
    }
    //Retorna si el arbol binario tiene el nodo que contiene a x
    public  boolean contains(T x){
        return  contains(x, root);
    }
    //Llama recursivamente para verifiicar si el nodp actual contiene a x
    //si no se va a la derecha o a la izquierda
    public boolean contains(T x, BinaryNode<T> node){
        if(node==null){
            return  false;
        }
        if(x.compareTo(node.data)<0){
            return contains(x, node.left);
        }else if(x.compareTo(node.data)>0){
            return contains(x, node.rigth);
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
    public BinaryNode<T> findMin(BinaryNode<T> node){
        if(node.left==null){
            return node;
        }else{
            return findMin(node.left);
        }
    }
}
