/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearStructures;

/**
 *
 * @author jhonz
 */
public class Persona implements Comparable<Persona>{
    private int cedula;
    private int edad;
    private int hora;
    private int tiempo;
    
    
    //Crea una persona
    public Persona(int cedula, int edad, int hora, int tiempo) {
        this.cedula = cedula;
        this.edad = edad;
        this.hora = hora;
        this.tiempo = tiempo;
    }
    public int getCedula(){
        return cedula;
    }
    
     public int getEdad(){
        return edad;
    }
     public int getHora(){
        return hora;
    }
     public int getTiempo(){
        return tiempo;
    }

    @Override
    public int compareTo(Persona o) {
        if(this.edad>o.edad){
            return -1;
        }else if(this.edad<o.edad){
            return 1;
        }
        return 0;
    }  
}
