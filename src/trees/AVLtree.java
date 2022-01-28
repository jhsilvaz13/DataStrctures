/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trees;

import linearStructures.*;

/**
 *
 * @author jhonz
 */
public class AVLtree<T extends Comparable<? super T>> {

    private class AVLNode<T> {

        //Atributos AVL Node
        T data;
        AVLNode<T> left;
        AVLNode<T> right;
        int height;

        //Constructores
        public AVLNode(T data, AVLNode<T> left, AVLNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    //Atributos AVLtree
    private AVLNode<T> root;
    private static final int BALANCEADO = 1;

    //Constructores
    public AVLtree() {
        root = null;
    }

    /*Metodos*/
    //Hacer vacio el arbol
    public void makeEmpty() {
        root = null;
    }

    //Verificar si el arbol esta vacio
    public boolean isEmpty() {
        return root == null;
    }

    //Inserta un nuevo nodo binario
    public void insert(T x) {
        root = insert(x, this.root);
    }

    //Inserta recursivamente dependiendo si el nuevo dato es mayor o menor 
    //que el nodo actual por ultimo balancear
    private AVLNode<T> insert(T x, AVLNode<T> node) {
        if (node == null) {
            //System.out.println("trees.AVLtree.insert()");
            return new AVLNode<T>(x, null, null);
        }
        //x es menor que el nodo actual
        if (x.compareTo(node.data) < 0) {
            //System.out.println(x + " es menor que " + node.data);
            node.left = insert(x, node.left);
        } //x es mayor que el nodo actual
        else if (x.compareTo(node.data) > 0) {
            //System.out.println(x + " es mayor que " + node.data);
            node.right = insert(x, node.right);
        } else ;
        return balance(node);
    }

    //Retorna si el arbol binario tiene el nodo que contiene a x
    public boolean contains(T x) {
        return contains(x, root);
    }

    //Llama recursivamente para verifiicar si el nodo actual contiene a x
    //si no se va a la derecha o a la izquierda
    private boolean contains(T x, AVLNode<T> node) {
        if (node == null) {
            return false;
        }
        if (x.compareTo(node.data) < 0) {
            return contains(x, node.left);
        } else if (x.compareTo(node.data) > 0) {
            return contains(x, node.right);
        } else {
            return true;
        }
    }

    //Encontrar el minimo
    public T findMin() {
        if (this.isEmpty()) {
            System.out.println("El arbol esta vacio");
        } else {
            return findMin(root).data;
        }
        return null;
    }

    //Recorrer recursivamente los hijos izquierdos
    private AVLNode<T> findMin(AVLNode<T> node) {
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    //Encontrar el maximo
    public T findMax() {
        if (this.isEmpty()) {
            System.out.println("El arbol esta vacio");
        } else {
            return findMax(root).data;
        }
        return null;
    }

    //Recorrer recursivamente los hijos derechos
    private AVLNode<T> findMax(AVLNode<T> node) {
        if (node.right == null) {
            return node;
        } else {
            return findMax(node.right);
        }
    }

    //Eliminar un nodo con el dato x
    public void remove(T x) {
        root = remove(x, root);
    }

    //Elima recursivamente el nodo dependiendo si s una hoja, un nodo con un solo hijo o un nodo con dos hijos
    private AVLNode<T> remove(T x, AVLNode<T> node) {
        if (this.isEmpty()) {
            return node;
        }
        if (x.compareTo(node.data) < 0) {
            node.left = remove(x, node.left);
        } else if (x.compareTo(node.data) > 0) {
            node.right = remove(x, node.right);
        } else if (node.left != null && node.right != null) {
            node.data = findMin(node.right).data;
            node.right = remove(node.data, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return balance(node);
    }

    //BALANCEO
    private AVLNode<T> balance(AVLNode<T> node) {
        if (node == null) {
            return node;
        }
        //Comprobar si esta desbalanceado por izquierda
        if (height(node.left) - height(node.right) > BALANCEADO) {
            //Comprobar si el desbalanceo es LL O LR
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateLL(node);
            } else {
                node = rotateLR(node);
            }
        } else {
            //Comprobar si esta desbalanceado por derecha
            if (height(node.right) - height(node.left) > BALANCEADO) {
                //Comprobar si el desbalanceo es RR O RL
                if (height(node.right.right) >= height(node.right.left)) {
                    node = rotateRR(node);
                } else {
                    node = rotateRL(node);
                }
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    //Rotacion Left-Left
    private AVLNode<T> rotateLL(AVLNode<T> node) {
        AVLNode<T> aux = node.left;
        node.left = aux.right;
        aux.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        aux.height = Math.max(height(aux.left), height(aux.right)) + 1;
        return aux;
    }

    //Rotacion Left-Right
    private AVLNode<T> rotateLR(AVLNode<T> node) {
        node.left = rotateRR(node.left);
        return rotateLL(node);
    }

    //Rotacion Right-Right
    private AVLNode<T> rotateRR(AVLNode<T> node) {
        AVLNode<T> aux = node.right;
        node.right = aux.left;
        aux.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        aux.height = Math.max(height(aux.left), height(aux.right)) + 1;
        return aux;
    }

    //Rotacion Right-Left
    private AVLNode<T> rotateRL(AVLNode<T> node) {
        node.right = rotateLL(node.right);
        return rotateRR(node);
    }

    //Altura
    private int height(AVLNode<T> node) {
        if (node == null) {
            return -1;
        } else {
            return node.height;
        }
    }

    //Impresion preorden
    public void printPreorden() {
        printPreorden(root);
        System.out.println();
    }

    private void printPreorden(AVLNode<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreorden(node.left);
            printPreorden(node.right);
        }
    }

    //Impresion postorden
    public void printPostorden() {
        printPostorden(root);
        System.out.println();
    }

    private void printPostorden(AVLNode<T> node) {
        if (node != null) {
            printPostorden(node.left);
            printPostorden(node.right);
            System.out.print(node.data + " ");
        }
    }

    //Impresion inorden
    public void printInorden() {
        printInorden(root);
        System.out.println();
    }

    private void printInorden(AVLNode<T> node) {
        if (node != null) {
            printInorden(node.left);
            System.out.print(node.data + " ");
            printInorden(node.right);
        }
    }

    //Impresion por niveles
    public void printNiveles() {
        printNiveles(root);
        System.out.println();
    }
    private void printNiveles(AVLNode<T> node) {
        Queue<AVLNode<T>> cola = new Queue<AVLNode<T>>();
        cola.Enqueue(new Node<AVLNode<T>>(node));
        while (!cola.isEmpty()) {
            AVLNode<T> aux = cola.Dequeue().getData();
            System.out.print(aux.data + " ");
            if (aux.left != null) {
                cola.Enqueue(new Node<AVLNode<T>>(aux.left));
            }
            if (aux.right != null) {
                cola.Enqueue(new Node<AVLNode<T>>(aux.right));
            }
        }
    }
    
    public DoubleLinkedList<T> containsAndPush(T x) {
        DoubleLinkedList<T> cola = new DoubleLinkedList<T>();
        return containsAndPush(x, root, cola);
    }

    //Llama recursivamente para verifiicar si el nodo actual contiene a x
    //si no se va a la derecha o a la izquierda
    private DoubleLinkedList<T> containsAndPush(T x, AVLNode<T> node, DoubleLinkedList<T> cola) {
        if (node == null) {
            return cola;
        }
        if (x.compareTo(node.data) < 0) {
            cola.pushBack(new Node<T>(node.data));
            return containsAndPush(x, node.left, cola);
        } else if (x.compareTo(node.data) > 0) {
            cola.pushBack(new Node<T>(node.data));
            return containsAndPush(x, node.right, cola);
        } else {
            cola.pushBack(new Node<T>(node.data));
            return cola;
        }
    }
}
/**
 *
 * 10 principal alpha beta barzeus barx habitacion patios piscina biblioteca
 * gimnasio 1 habitacion principal
 */
