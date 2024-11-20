package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShopDAO {

    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion conexion = new Conexion();
    private Connection cnn = conexion.getConexion();
    private boolean msg = false;

    public boolean create(Shop shop) throws SQLException {
        ps= cnn.prepareStatement("SELECT name FROM shop WHERE name = ?");
        ps.setString(1, shop.getName());
        rs = ps.executeQuery();
        if (rs.next()){
            return false;
        }else{
            ps = cnn.prepareStatement("INSERT INTO shop(name, id_status) values(?,?)");
            ps.setString(1, shop.getName());
            ps.setString(2, shop.getId_status());
            //ps.executeUpdate();
            msg = ps.executeUpdate()>0;
            return msg;
        }
    }

    public ArrayList<Shop> consultar() throws SQLException{
        ArrayList<Shop> datos = new ArrayList<>();
        ps = cnn.prepareStatement("SELECT * FROM shop");
        rs= ps.executeQuery();
        while(rs.next()){
            Shop shop = new Shop(rs.getString("name"), rs.getString("id_status"));

            datos.add(shop);
        }
        return datos;
    }

    public boolean actualizarEstado(Shop shop) throws SQLException {
        ps = cnn.prepareStatement("UPDATE shop SET id_status=? where name =?");
        ps.setString(1, shop.getId_status());
        ps.setString(2, shop.getName());
        //ps.executeUpdate();
        msg = ps.executeUpdate()>0;
        return msg;
    }

    public boolean eliminarTienda(Shop shop) throws SQLException {
        ps = cnn.prepareStatement("DELETE FROM shop where name = ?");
        ps.setString(1, shop.getName());
        //ps.executeUpdate();
        msg = ps.executeUpdate()>0;
        return msg;
    }
}
