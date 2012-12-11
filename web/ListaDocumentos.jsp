<%-- 
    Document   : ListaDocumentos
    Created on : 23-nov-2012, 19:36:34
    Author     : al036309
--%>

<%@page import="org.sofia.beans.UsuarioBean"%>
<%@page import="java.util.List"%>
<%@page import="org.sofia.beans.ComentarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="org.sofia.beans.DocumentoBean" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Documentos</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/estilo.css"/>
    </head>
    <body>

        <%
            UsuarioBean user = (UsuarioBean) this.getServletContext().getAttribute("usuario");
        %>
        <div class="span10 well">

            <div class="navbar navbar-inverse nav">
                <div class="navbar-inner">
                    <div class="container">

                        <div class="nav-collapse collapse">
                            <ul class="nav">
                                <li><a href="#"><i class="icon-home icon-white"></i> Lista Documentos</a></li>
                            </ul>
                            <div class="pull-right">
                                <ul class="nav pull-right">
                                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome, <%=user.getNombre()%> <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="/auth/logout"><i class="icon-off"></i> Logout</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            <div class="tabla span7" >

                <%
                    List<DocumentoBean> lista = (List<DocumentoBean>) request.getAttribute("lista");
                %>
                <table class="table table-hover">

                    <tr class="info" style="font-weight: bold;" >
                        <td class="span1" style="text-align: center;">Id</td>
                        <td class="span4" style="text-align: center;">Titulo</td>
                        <td class="span1" style="text-align: center;">Alumno</td>
                    </tr>
                    <%for (int i = 0; i < lista.size(); i++) {
                            DocumentoBean documento = lista.get(i);%>

                    <tr class="info"  >
                        <td  class="span1" style="text-align: center;">
                            <a href="documento?id=<%=documento.getId()%>&op=visualizar">
                                <%=documento.getId()%> </a>
                        </td>
                        <td  class="span4" style="text-align: center;"><%=documento.getTitulo()%></td>
                        <td class="span1" style="text-align: center;"><%=documento.getUsuario().getNombre()%></td>
                    </tr>




                    <%}%>     






                </table>
            </div>

            <a href="LogOut.jsp" class="btn btn-large btn-info" style="margin-left: 300px;">Cerrar Sesion</a>
        </div>


    </body>
</html>


