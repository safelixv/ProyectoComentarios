<%-- 
    Document   : ListaDocumentos
    Created on : 23-nov-2012, 19:36:34
    Author     : al036309
--%>

<%@page import="org.sofia.beans.UsuarioBean"%>
<%@page import="org.sofia.beans.ComentarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="org.sofia.beans.DocumentoBean" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Documentos Comentados</title>
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
                                <li><a href="#"><i class="icon-home icon-white"></i> Lista Documentos Comentados</a></li>
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
                <table class="table table-hover">


                    <tr class="info" style="font-weight: bold;" >

                        <%
                            DocumentoBean doc = (DocumentoBean) request.getAttribute("documento");
                        %>

                        <td class="span4" style="text-align: center;"><%=doc.getTitulo()%></td>

                    </tr>

                    <tr class="info">

                        <td class="span4" style="text-align: center;"><%=doc.getContenido()%></td>

                    </tr>

                </table>




                <%for (int i = 0; i < doc.getComentarios().size(); i++) {
                        ComentarioBean comentario = doc.getComentarios().get(i);%>


                <div class="well3 span2"> 
                    <span> <%=comentario.getTitulo()%> </span>
                </div>

                <div class="botones">
                    <a href="comentario?id=<%=comentario.getId()%>&op=modificar" class="btn btn-primary">Editar</a>
                    <a href="comentario?id=<%=comentario.getId()%>&op=delete" class="btn btn-primary">Eliminar </a>





                </div>


                <div class="well2 span6">

                    <p> <%=comentario.getContenido()%> </p>

                </div>

                <div class="well4 span2"> 
                    <span> <%=comentario.getUsuario().getNombre()%> </span>
                </div>

                <div class="well4 span2"> 
                    <span> <%=comentario.getFecha()%> </span>
                </div>


                <%}%>


            </div>


            <div class="botones2">

                <a class="btn btn-large btn-info" href="documento?id=<%=doc.getId()%>&op=insert">Nuevo</a>

                <a href="LogOut.jsp" class="btn btn-large btn-info">Cerrar Sesion</a>

            </div>

            <%--
            <h1>Listado Documento</h1>
            <% 
                DocumentoBean doc = (DocumentoBean)request.getAttribute("documento");
            %>
            <h2><%=doc.getTitulo()%></h2>
             <h2><%=doc.getContenido()%></h2>
             </br>
             <%for(int i=0;i<doc.getComentarios().size();i++){
                 ComentarioBean comentario = doc.getComentarios().get(i);%>
                 <a><%=comentario.getFecha()%></a>
                 <a>--></a>
                 <a><%=comentario.getContenido()%></a>
                 <a>&nbsp;</a>
                 <a href="comentario?id=<%=comentario.getId()%>&op=delete">Eliminar </a>
                 
                 </br>
            
             <%}%>
            --%>

    </body>
</html>
