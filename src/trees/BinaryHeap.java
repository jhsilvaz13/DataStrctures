/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trees;

import linearStructures.ArrayList;

/**
 *
 * @author jhonz
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private int n = 0;
    private T array[];

    public BinaryHeap() {
        clear();
        array[0]=null;
        n++;
    }

    public void enqueue(T e) {
        if (n == 1) {
            array = (T[]) new Comparable[2];
            array[n] = e;
            n++;
        } else {
            array[n] = e;
            n++;
            if (n == array.length) {
                T Aprima[] = (T[]) new Comparable[2*array.length];
                for (int i = 0; i < array.length; i++) {
                    Aprima[i] = array[i];
                }
                array = Aprima;
            }   
        }
        percolateUp(e);
    }

    public T findMin() {
        if (!isEmpty()) {
            return array[1];
        }
        return null;
    }

    public T deleteMin() {
        if (!isEmpty()) {
            T minItem = findMin();
            array[1] = array[n--];
            percolateDown(1);
            return minItem;
        }
        return null;
    }

    private void percolateUp(T e) {
        int hole = n++;
        for (array[0] = e; e.compareTo(array[n / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
              System.out.println(hole);
        }
        array[hole] = e;                  
        
    }

    private void percolateDown(int index) {
        int child;
        T tmp = array[index];
        for (; index * 2 <= n; index = child) {
            child = index * 2;
            if (child != n && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[index] = array[child];
            } else {
                break;
            }
        }
        array[index] = tmp;
    }

    public void clear() {
        this.n = 0;
        array = (T[]) new Comparable[2];
    }

    public Boolean isEmpty() {
        return (this.n == 1) ? true : false;
    }
    
    public void printArray(){
        for(int i=1; i<n;i++){
            System.out.println(array[i]);
        }
    }
}
