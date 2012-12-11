/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sofia.beans;

import java.sql.Date;

/**
 *
 * @author Sofia Felix
 */
public class ComentarioBean {
    
    private Integer id=null;
    private String titulo="";
    private String contenido="";
    private Date fecha;
    private UsuarioBean usuario;
    private Integer idDocumento = null;
  //  private Integer Nota;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the usuario
     */
    public UsuarioBean getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the idDocumento
     */
    public Integer getIdDocumento() {
        return idDocumento;
    }

    /**
     * @param idDocumento the idDocumento to set
     */
    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

   

   
   
   
    
}
