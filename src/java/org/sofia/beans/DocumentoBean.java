/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sofia.beans;

import java.util.ArrayList;

/**
 *
 * @author Sofia Felix
 */
public class DocumentoBean {
    
    private Integer id;
    private String titulo;
    private String contenido;
    private String fecha;
    private UsuarioBean usuario;
    private String etiquetas;
    private Boolean privado;
    private ArrayList<ComentarioBean> comentarios;

    public DocumentoBean(){
        comentarios = new ArrayList<ComentarioBean>();
    }
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
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
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
     * @return the etiquetas
     */
    public String getEtiquetas() {
        return etiquetas;
    }

    /**
     * @param etiquetas the etiquetas to set
     */
    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * @return the privado
     */
    public Boolean getPrivado() {
        return privado;
    }

    /**
     * @param privado the privado to set
     */
    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    /**
     * @return the comentarios
     */
    public ArrayList<ComentarioBean> getComentarios() {
        return comentarios;
    }

 
    
}
