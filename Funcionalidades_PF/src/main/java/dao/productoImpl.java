/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modell.producto;

/**
 *
 * @author Paul
 */
public class productoImpl extends Conexion{
    public List listar() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<producto> listado = null;
        String sql = "";
        producto prov;
        try {
            listado = new ArrayList();
            sql="SELECT * FROM PRODUCTO";
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                prov = new producto();
                prov.setId(rs.getInt("IDPRO"));
                prov.setNombre(rs.getString("NOMPRO"));
                prov.setMarca(rs.getString("MARPRO"));
                prov.setPrecio_compra(rs.getDouble("PRECOMPRO"));
                prov.setPrecio_venta(rs.getDouble("PREVENPRO"));
                prov.setStock(rs.getInt("STOPRO"));
                prov.setDescripcion(rs.getString("DESPRO"));
                prov.setEstado(rs.getString("ESTPRO"));
                prov.setImagen(rs.getString("IMAPRO"));

                listado.add(prov);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en lsistarImpl" + e.getMessage());
        }
        return listado;
    }
}
