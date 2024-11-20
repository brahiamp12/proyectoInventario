package controlador;

import modelo.Shop;
import modelo.ShopDAO;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador {
    ShopDAO shopDAO = new ShopDAO();
    public boolean datosTienda(Object json) throws SQLException {
        JSONObject jsonObject = new JSONObject(json.toString());
        String name = jsonObject.getJSONArray("name").getString(0);
        String id_status = jsonObject.getJSONArray("id_status").getString(0);
        System.out.println("Tienda: " + name);
        System.out.println("id_status: " + id_status);
        Shop shop = new Shop(name, id_status);
        shopDAO.create(shop);
        return true;
    }

    public ArrayList<Shop>consultarTienda() throws SQLException{
        return shopDAO.consultar();
    }

    public boolean actualizarEstado(String name, String id_status) throws SQLException {
        Shop shop = new Shop(name, id_status);
        boolean res = shopDAO.actualizarEstado(shop);
        return res;
    }

    public boolean eliminarTienda(String name) throws SQLException {
        Shop shop = new Shop(name);
        boolean res = shopDAO.eliminarTienda(shop);
        return res;
    }
}
