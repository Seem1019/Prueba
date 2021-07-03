/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.google.gson.Gson;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steve
 */
public class ProductosDAO {
    Connection conexion;
    public ProductosDAO(){
        Conexion con = new Conexion();
        conexion=con.getConexion();
    }
    
    public String listarProductos(){
        
        PreparedStatement ps;
        ResultSet rs;
        List<Productos> lista =new ArrayList<>();
        try{
          
            ps=conexion.prepareStatement("SELECT * FROM fineract.productos;");
            
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre= rs.getString("nombre");
                Double precio= rs.getDouble("precio");
                int existencia = rs.getInt("existencia");
                
                Productos producto= new Productos(id, codigo, nombre, precio, existencia);
                lista.add(producto);
                
            }
            
            ps.close();
            rs.close();
            String json = new Gson().toJson(lista);
            System.out.println(json); 
            return json;
        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
        
    }
}
