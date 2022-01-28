/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hashing;

import linearStructures.LinkedList;
import linearStructures.Node;

/**
 *
 * @author jhonz
 */
public class HashTable<T> {

    private LinkedList<T>[] array;
    private int currentSize;
    private static final int DEFAULT_CAPACITY = 101;

    //CONSTRUCTORES
    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int size) {
        array = new LinkedList[nextPrime(size)];
        for (int i = 0; i < array.length; i++) {
            array[i] = new LinkedList<T>();
        }
    }
    //Metodos publicos
    public void insert(T x) {
        LinkedList<T> aux = array[hashFun(x)];
        if (!aux.find(x)) {
            aux.pushBack(new Node<T>(x));
            if( ++currentSize > (array.length*5) )
                rehash( );
        }
    }

    public void remove(T x){
        LinkedList<T> aux=array[hashFun(x)];
        aux.delete(x);
        currentSize--;
    }

    public boolean search(T x) {
        return array[hashFun(x)].find(x);
    }

    //Metodos internos
    private void rehash() {
        LinkedList<T>[] aux = array;
        array = new LinkedList[nextPrime(2 * array.length)];
        for (int i = 0; i < array.length; i++) {
            array[i] = new LinkedList<T>();
        }
        for (LinkedList<T> e : aux) {
            if (e.getBeginNode() != null) {
                Node<T> iterator = e.getBeginNode();
                insert(iterator.getData());
                while (iterator.nextNode() != null) {
                    iterator = iterator.nextNode();
                    insert(iterator.getData());
                }
            }
        }
    }

    private int hashFun(T x) {
        int hashVal = x.hashCode();
        hashVal %= array.length;
        if (hashVal < 0) {
            hashVal += array.length;
        }
        return hashVal;
    }

    private int nextPrime(int n) {
        if (n % 2 == 0) {
            n += 1;
        }
        while (!isPrime(n)) {
            n += 2;
        }
        return n;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int i = 2;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    /*public static void main(String[] args) {
        HashTable<Integer> hash = new HashTable<Integer>();
        for (int i = 0; i < 1000; i++) {
            hash.insert(i);
        }
        for (int i = 0; i < 1000; i++) {
            hash.remove(i);
        }
        for (int i = 0; i < 1000; i++) {
            if (hash.search(i)) {
            }
        }
    }*/

}
