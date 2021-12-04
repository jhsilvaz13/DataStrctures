/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures.problemaEnvios;

import linearStructures.Node;
import linearStructures.Queue;

/**
 *
 * @author jhonz
 */
public class Camion {
    private Queue<Paquete> paquetes=new Queue<Paquete>();
    private double xRegion;
    private double yRegion;
    
    public  Camion(double xRegion, double yRegion){
        this.xRegion=xRegion;
        this.yRegion=yRegion;
    }
    
    public void encolarPaquete(Paquete p){
        paquetes.Enqueue(new Node<Paquete>(p));
    }
    public Node<Paquete> desencolarPaque(){
        return paquetes.Dequeue();
    } 
    public Queue<Paquete> getColaPaquetes(){
        return paquetes;
    }
    
    
    public double getxRegion(){
        return xRegion;
    }
    
    public double getyRegion() {
        return yRegion;
    }
    
}
