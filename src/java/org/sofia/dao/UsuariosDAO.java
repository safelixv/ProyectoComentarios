/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sofia.dao;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sofia.beans.RoleBean;
import org.sofia.beans.UsuarioBean;
import org.sofia.conexion.Mysql;

/**
 *
 * @author al036309 Sofia Felix
 */
public class UsuariosDAO {

    public UsuarioBean getUsuario(String nombre, String password) throws Exception {

        ResultSet rs = null;
        UsuarioBean usuario = null;

        try {

            Mysql.conexion();
            String consulta = "select * from usuario where login = '" + nombre + "' and password = '" + password + "'";
            rs = Mysql.execSQL(consulta);



            do {

                usuario = new UsuarioBean();
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApe1(rs.getString(3));
                usuario.setApe2(rs.getString(4));
                usuario.setTelefono(rs.getString(5));
                usuario.setEmail(rs.getString(6));
                usuario.setLogin(rs.getString(8));
                usuario.setPassword(rs.getString(9));
                int tipoUsr = rs.getInt(7);
               
                RoleBean role = getRole(tipoUsr);
                usuario.setRole(role);
              

            } while (rs.next());
             Mysql.desconexion();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return usuario;
    }

    private RoleBean getRole(int tipoUsr) {
        RoleBean role = new RoleBean();
        role.setId(tipoUsr);
        try {
            Mysql.conexion();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String consulta = "select * from tipo_usuario where id = " + tipoUsr;
        ResultSet rs;
        try {
            rs = Mysql.execSQL(consulta);
            do {
                role.setDescripcion(rs.getString(2));
               
            } while (rs.next());
            
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        try {
            Mysql.desconexion();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }




        return role;

    }
}
