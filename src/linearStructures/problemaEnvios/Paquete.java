/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures.problemaEnvios;

/**
 *
 * @author jhonz
 */
public class Paquete {
    private int serial;
    private int x;
    private int y;
    
    public Paquete(int serial, int x, int y){
        this.serial=serial;
        this.x=x;
        this.y=y;
    }

    public  int getSerial(){
        return serial;
    }
    public int getX(){
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    
}
