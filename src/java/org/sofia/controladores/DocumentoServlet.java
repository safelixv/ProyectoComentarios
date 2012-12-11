/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sofia.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sofia.beans.ComentarioBean;
import org.sofia.beans.DocumentoBean;
import org.sofia.beans.UsuarioBean;
import org.sofia.services.DocumentosService;

/**
 *
 * @author Sofia Felix
 */
@WebServlet(name = "DocumentoServlet", urlPatterns = {"/documento"})
public class DocumentoServlet extends HttpServlet {

    DocumentoBean doc;

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idDocumento = request.getParameter("id");
        String operacion = request.getParameter("op");
        if (operacion.equals("insert")) {
                insertarComentario(request, response, idDocumento);
        } else { //visualizar
            visualizar(request, response, idDocumento);
            
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void insertarComentario(HttpServletRequest request, HttpServletResponse response, String idComentario) {
        ComentarioBean comentario = new ComentarioBean();
        
         UsuarioBean u =   (UsuarioBean) this.getServletContext().getAttribute("usuario");
       
        
        comentario.setUsuario(u);
        comentario.setIdDocumento(Integer.parseInt(idComentario));
        Date fecha = Calendar.getInstance().getTime();
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        comentario.setFecha(sqlDate);
        request.setAttribute("comentario", comentario);
        try {
            //processRequest(request, response);
            this.getServletContext().getRequestDispatcher("/editar.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ComentarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ComentarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void visualizar(HttpServletRequest request, HttpServletResponse response, String idDocumento) {
       DocumentosService servicio = new DocumentosService();
            doc = servicio.getDocumento(idDocumento);
            request.setAttribute("documento", doc);
        try {
            //processRequest(request, response);
            this.getServletContext().getRequestDispatcher("/documento.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(DocumentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
