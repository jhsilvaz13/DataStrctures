/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysqlconnect;

import java.io.File;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author jhonz
 */
public class Mysqlconnect {

    private Connection conexion = null;

    public Mysqlconnect() {
        crearyConectarBase();
    }

    private void crearyConectarBase() {
        /*String usuario="Programador";
        String clave="/[brQ@6gZ06-ZTJX";*/
        String usuario = "root";
        String clave = "";
        String url = "jdbc:mysql://localhost:3306/";
        try {
            //Crear una conexion de la libreria y conectarse a la base(crear localmente)
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, clave);
            //Crear estructura de la base de datos
            Statement sqlCr = conexion.createStatement();
            Scanner scan=new Scanner(new File("..\\DataStructures\\src\\mysqlconnect\\Shipping.sql"));
            String sentencia="";
            //Leer archivo sql para crear la estructura
            while (scan.hasNextLine()) {
                String aux=scan.nextLine();
                sentencia=sentencia+aux;
                if(sentencia.compareTo("")!=0 && sentencia.contains(";")){
                    sqlCr.execute(sentencia);
                    sentencia="";
                }
            }
        } catch (Exception e) {
            System.out.println("Hubo un error en la conexion de la base de datos, el error es :" + e.getMessage());
        }
    }

    public void registrarUsuario(String nombreTabla, String nombre) {
        try {
            Statement sqlSt = conexion.createStatement();
            sqlSt.execute("INSERT INTO " + nombreTabla + " VALUES (null,'" + nombre + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void iniciarSesion(String nombreUsuario) {
        try {
            Statement sqlSt = conexion.createStatement();
            String query = "SELECT * FROM usuarios WHERE NombreUsuario='" + nombreUsuario + "'";
            ResultSet resultado = sqlSt.executeQuery(query);
            resultado.next();
            if (resultado != null) {
                System.out.println("El usuario con id=" + resultado.getString("ID") + " y nombre: " + resultado.getString("NombreUsuario"));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Mysqlconnect con=new Mysqlconnect();
    }
}
