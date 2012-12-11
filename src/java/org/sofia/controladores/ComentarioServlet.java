/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sofia.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sofia.beans.ComentarioBean;
import org.sofia.beans.UsuarioBean;
import org.sofia.services.DocumentosService;

/**
 *
 * @author Sofia Felix
 */
@WebServlet(name = "ComentarioServlet", urlPatterns = {"/comentario"})
public class ComentarioServlet extends HttpServlet {

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
        String id = request.getParameter("id");
        String operacion = request.getParameter("op");
        DocumentosService service = new DocumentosService();
        ComentarioBean comentario = service.getComentario(id);
        if (operacion.equals("delete")) {
            borrar(service, response, comentario);
        }



        if (operacion.equals("modificar")) {
            editar(service, request, response, comentario);
        }
        try {
            response.sendRedirect("documento?id=" + comentario.getIdDocumento() + "&op=visualizar");
        } catch (IOException ex) {
            Logger.getLogger(ComentarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            // try {
            ComentarioBean com = new ComentarioBean();
            com.setTitulo(request.getParameter("titulo"));

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            com.setFecha(new Date(df.parse(request.getParameter("fecha")).getTime()));

            com.setContenido(request.getParameter("contenido"));

            DocumentosService service = new DocumentosService();
            String id = request.getParameter("idcomentario");

            //si trae id, es un comentario ya existete por tanto lo actualiza
            if (!id.equals("null")) {
                com.setId(Integer.parseInt(id));
                service.update(com);
                com = service.getComentario(id);
            } else { // y aqui lo inserta, pq es uno nuevo
                String idDocumento = request.getParameter("iddocumento");
                String idUsuario = request.getParameter("idusuario");
                UsuarioBean u = new UsuarioBean();
                u.setId(Integer.parseInt(idUsuario));
                com.setUsuario(u);
                com.setIdDocumento(Integer.parseInt(idDocumento));
                service.insertar(com);

            }
            response.sendRedirect("documento?id=" + com.getIdDocumento() + "&op=visualizar");


            /*
             * } catch (ParseException ex) {
             * Logger.getLogger(ComentarioServlet.class.getName()).log(Level.SEVERE,
             * null, ex); }
             */
        } catch (ParseException ex) {
            Logger.getLogger(ComentarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    private void borrar(DocumentosService service, HttpServletResponse response, ComentarioBean comentario) {

        UsuarioBean usuario = (UsuarioBean) this.getServletContext().getAttribute("usuario");
        boolean borrado = service.deleteComentario(comentario, usuario);


    }

    private void editar(DocumentosService service, HttpServletRequest request, HttpServletResponse response, ComentarioBean comentario) {


        UsuarioBean usuario = (UsuarioBean) this.getServletContext().getAttribute("usuario");

        if (usuario.getRole().getDescripcion().equals("alumno")) {
            if (comentario.getUsuario().getId() != usuario.getId()) {
                System.out.print("\nPermiso denegado");
                return;

            }

        }

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
}
