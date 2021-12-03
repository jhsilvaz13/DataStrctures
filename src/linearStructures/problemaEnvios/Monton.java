/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures.problemaEnvios;

import linearStructures.Node;
import linearStructures.Stack;

/**
 *
 * @author jhonz
 */
public class Monton {
    private Stack<Paquete> paquetes=new Stack<Paquete>();
    public void addPaquete(Paquete p){
        paquetes.push(new Node<Paquete>(p));
    }
    
    public Stack<Paquete> getPilasPaquetes(){
        return paquetes;
    }
}
