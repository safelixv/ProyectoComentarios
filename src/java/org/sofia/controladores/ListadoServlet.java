/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sofia.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sofia.beans.DocumentoBean;
import org.sofia.beans.UsuarioBean;
import org.sofia.services.DocumentosService;

/**
 *
 * @author Sofia Felix
 */
@WebServlet(name = "ListadoServlet", urlPatterns = {"/listado"})
public class ListadoServlet extends HttpServlet {

   

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
       // processRequest(request, response);
        
       
        DocumentosService servicio = new DocumentosService();
        List<DocumentoBean> lista = servicio.getDocumentos();
        
        request.setAttribute("lista", lista);
        //processRequest(request, response);
        this.getServletContext().getRequestDispatcher("/ListaDocumentos.jsp").forward(request, response);
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
}
