/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sofia.services;

import java.util.ArrayList;
import java.util.List;
import org.sofia.beans.ComentarioBean;
import org.sofia.beans.DocumentoBean;
import org.sofia.beans.UsuarioBean;
import org.sofia.dao.DocumentosDAO;

/**
 *
 * @author Sofia Felix
 */
public class DocumentosService {

    private DocumentosDAO dao;
    public DocumentosService() {
        dao = new DocumentosDAO();
    }
    
    public List<DocumentoBean> getDocumentos(){
      
    
    return dao.getDocumentos();
    }

    public DocumentoBean getDocumento(String id) {
        return  dao.getDocumento(id);
        
    }

    public boolean deleteComentario(ComentarioBean comentario, UsuarioBean usuario) {
        if (usuario.getRole().getDescripcion().equals("alumno")){
             if (comentario.getUsuario().getId()!= usuario.getId()){
                System.out.print("\nPermiso denegado");
                return false;
            }
        
        }
       
        dao.deleteComentario(comentario.getId());
        return true;
    }

    public ComentarioBean getComentario(String id) {
         int idComentario = Integer.parseInt(id);
         return dao.getComentario(idComentario);
    }

    public void update(ComentarioBean com) {
        dao.update(com);
    }

    public void insertar(ComentarioBean com) {
        dao.insert(com);
    }

    
    
}
