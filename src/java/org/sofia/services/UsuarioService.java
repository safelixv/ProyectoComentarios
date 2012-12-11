/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sofia.services;

import org.sofia.beans.UsuarioBean;
import org.sofia.dao.UsuariosDAO;


/**
 *
 * @author Sofia Felix
 */
public class UsuarioService {
    private UsuariosDAO dao = new UsuariosDAO();
    
    public UsuarioBean login(String nombre, String password) throws Exception{
    
        UsuarioBean usuario = dao.getUsuario(nombre, password);
       
       
        return usuario; 
    }
    
}
