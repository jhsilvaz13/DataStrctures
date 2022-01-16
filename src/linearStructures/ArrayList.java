/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
public class ArrayList<T>{
    private int n=0;
    private T array[];
    public ArrayList(){
        clear();
    }
    public void push(T e){
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
    
    public T pop(){
        T e=array[n];
        array[n]=null;
        n--;
        if(((double)n/(double)array.length)<=((double)(1./4.))){
            T Aprima[]=(T[])new Object[n*2];
            for(int i=0; i<n*2;i++){
                    Aprima[i]=array[i];
                }
            array=Aprima;
        }
        return e;
    }
    
    public T get(int index){
        if(index<0 || index>=getLen()){
            System.out.println("Indice fuera de rango");
            return null;
        }
        return array[index];
    }
    
    public T set(int index, T e){
        if(index<0 || index>=getLen()){
            System.out.println("Indice fuera de rango");
            return null;
        }
        T old=array[index];
        array[index]=e;
        return old;
    }
    public void clear(){
       this.n=0;
       this.array=(T[]) new Object[2];
    }
    
    public Boolean isEmpty(){
        return  (this.n==0)?true:false;
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
