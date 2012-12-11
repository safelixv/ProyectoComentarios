/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sofia.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sofia.beans.ComentarioBean;
import org.sofia.beans.DocumentoBean;
import org.sofia.beans.UsuarioBean;
import org.sofia.conexion.Mysql;

/**
 *
 * @author Sofia Felix
 */
public class DocumentosDAO {

    public List<DocumentoBean> getDocumentos() {
        List<DocumentoBean> lista = new ArrayList<DocumentoBean>();

        DocumentoBean tmpDocumento;
        ResultSet rs = null;
        UsuarioBean usuario = null;

        try {

            Mysql.conexion();
            String consulta = "SELECT * FROM documento";
            rs = Mysql.execSQL(consulta);



            do {

                tmpDocumento = new DocumentoBean();
                tmpDocumento.setId(rs.getInt(1));
                tmpDocumento.setTitulo(rs.getString(2));

                usuario = this.getUsuario(rs.getInt(6));
                tmpDocumento.setUsuario(usuario);

                lista.add(tmpDocumento);


            } while (rs.next());
            Mysql.desconexion();
        } catch (Exception e) {
            e.printStackTrace();
        }




        return lista;
    }

    public DocumentoBean getDocumento(String id) {
        DocumentoBean tmpDocumento = null;
        ResultSet rs = null;
        UsuarioBean usuario = null;

        try {

            Mysql.conexion();
            String consulta = "SELECT * FROM documento where id=" + id;
            System.out.print("klsdjflsk " + consulta);
            rs = Mysql.execSQL(consulta);


            // recuperamos documento
            tmpDocumento = new DocumentoBean();
            tmpDocumento.setId(rs.getInt(1));
            tmpDocumento.setTitulo(rs.getString(2));
            tmpDocumento.setContenido(rs.getString(3));
            
   
            
            tmpDocumento.setUsuario(getUsuario(rs.getInt(6)));

            //recuperar comentarios;
            consulta = "SELECT * FROM comentario where id_documento=" + tmpDocumento.getId() + " order  by fecha desc";
            rs = Mysql.execSQL(consulta);
            ComentarioBean tmpComentario;
           
            try{
                do {
                        
                    tmpComentario = new ComentarioBean();
                    tmpComentario.setId(rs.getInt(1));
                    tmpComentario.setTitulo(rs.getString(2));
                    tmpComentario.setContenido(rs.getString(3));
                    tmpComentario.setFecha(rs.getDate(4));
                    tmpComentario.setUsuario(getUsuario(rs.getInt(5)));


                    tmpDocumento.getComentarios().add(tmpComentario);


                } while (rs.next());
            }catch(Exception e){
                System.out.printf("no hay comentarios?");
            }
            Mysql.desconexion();

        } catch (Exception e) {
            e.printStackTrace();
        }




        return tmpDocumento;
    }

    public void deleteComentario(int idComentario) {
        //  String consulta = "delete FROM comentario where id=" + idComentario;
        try {
            Mysql.conexion();
            Mysql.removeOne(idComentario, "comentario");
            Mysql.desconexion();
        } catch (Exception ex) {
            Logger.getLogger(DocumentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private UsuarioBean getUsuario(int id) {
        UsuarioBean user = new UsuarioBean();
        String consulta = "SELECT * FROM usuario where id=" + id;
        try {
            Mysql.conexion();
        } catch (Exception ex) {
            Logger.getLogger(DocumentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = Mysql.execSQL(consulta);
            user.setId(id);
            user.setNombre(rs.getString(2));
        } catch (Exception ex) {
            Logger.getLogger(DocumentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return user;
    }

    public ComentarioBean getComentario(int idComentario) {
        ComentarioBean comentario = new ComentarioBean();

        String consulta = "SELECT * FROM comentario where id=" + idComentario;
        try {
            Mysql.conexion();
        } catch (Exception ex) {
            Logger.getLogger(DocumentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = Mysql.execSQL(consulta);

            comentario.setId(rs.getInt(1));
            comentario.setTitulo(rs.getString(2));
            comentario.setContenido(rs.getString(3));
            comentario.setFecha(rs.getDate(4));
            comentario.setUsuario(getUsuario(rs.getInt(5)));
            comentario.setIdDocumento(rs.getInt(6));


        } catch (Exception ex) {
            Logger.getLogger(DocumentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return comentario;
    }

    public void update(ComentarioBean com) {
        try {
            Mysql.conexion();
            Mysql.updateOne(com.getId(), "comentario", "titulo", com.getTitulo());
            Mysql.updateOne(com.getId(), "comentario", "fecha", com.getFecha().toString());
            Mysql.updateOne(com.getId(), "comentario", "contenido", com.getContenido());
            Mysql.desconexion();
        } catch (Exception ex) {
            Logger.getLogger(DocumentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(ComentarioBean com) {
        try {
            Mysql.conexion();
            String sql = "INSERT INTO comentario (`titulo`,`contenido`,`fecha`,`id_usuario`,`id_documento`)"
                    + "VALUES ('" + com.getTitulo() + "','" + com.getContenido() + "','" + com.getFecha().toString() + "',"
                    + com.getUsuario().getId() + "," + com.getIdDocumento() + ")";

            Mysql.insertar(sql);

            Mysql.desconexion();
        } catch (Exception ex) {
            Logger.getLogger(DocumentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
