package vista;

import controlador.Controlador;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Shop;
import org.json.JSONObject;

public class Vista {
    private String name;
    private String id_status;
    Controlador controlador = new Controlador();

    public void Vista() throws SQLException {
        name = JOptionPane.showInputDialog("Digite nombre de la tienda");
        id_status = JOptionPane.showInputDialog("Digite estado de la tienda (1 activa, 0 inactiva)");
        JSONObject jsonTienda = new JSONObject();
        jsonTienda.append("name", name);
        jsonTienda.append("id_status", id_status);
        boolean res = controlador.datosTienda(jsonTienda.toString());
        if (res){
            JOptionPane.showMessageDialog(null, "existoso");
        }else{
            JOptionPane.showMessageDialog(null,"error");
        }
        //consulta
        ArrayList<Shop>datos = new ArrayList<>();
        datos = controlador.consultarTienda();
        for (Shop c:datos){

            System.out.println(c.getName());
        }
        //actualizar
        name = JOptionPane.showInputDialog("Digite nombre de la tienda");
        id_status = JOptionPane.showInputDialog("Digite estado nuevo de la tienda (1 activa, 0 inactiva)");
        boolean msg = controlador.actualizarEstado(name, id_status);
        if (msg){
            JOptionPane.showMessageDialog(null, "Actualización existosa");
        }else{
            JOptionPane.showMessageDialog(null,"Error");
        }

        //eliminar
        name = JOptionPane.showInputDialog("Digite nombre de la tienda que desea eliminar");
        boolean msgDelete = controlador.eliminarTienda(name);
        if (msgDelete){
            JOptionPane.showMessageDialog(null, "Eliminación existosa");
        }else{
            JOptionPane.showMessageDialog(null,"Error en la Eliminación");
        }

    }
}
