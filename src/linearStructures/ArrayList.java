/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
public class ArrayList<  T>{
    private int n=0;
    private T array[];
    public ArrayList(){
    }
    public void add(T e){
        if(n==0){
            array=(T[]) new Object[2];
            array[n]=e;
            n++;
        }else{
            array[n]=e;
            n++;
            if(n==array.length){
                T Aprima[]=(T[])new Object[2*array.length];
                for(int i=0; i<array.length;i++){
                    Aprima[i]=array[i];
                }
                array=Aprima;
            }
        }
    }
    public void print(){
        System.out.print("[");
        for(int i=0; i<n;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("]");
    }
    public int getN(){
        return n;
    }
    
    public int getLen(){
        return array.length;
    }

}   
