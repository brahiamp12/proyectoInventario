package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


    Connection cnn;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost/webcol","root", "");
            System.out.println("Conectado a la db");
            return cnn;
        } catch (Exception e) {
            System.out.println("error en la conexión "+e.getMessage());
        }
        return cnn;
    }

    public static void main(String[] args){
        Conexion con = new Conexion();
        con.getConexion();
    }
}
