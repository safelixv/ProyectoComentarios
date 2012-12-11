<%@page import="org.sofia.beans.UsuarioBean"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="org.sofia.beans.ComentarioBean"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
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

            <%
                ComentarioBean comentario = (ComentarioBean) request.getAttribute("comentario");
            %>

            <div class="well4">


                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane active in" id="home">
                        <form id="tab" action="comentario" method="post">
                            <label>Titulo</label>
                            <input type="hidden" value="<%=comentario.getUsuario().getId()%>" class="input-xlarge" name="idusuario" >
                                <input type="hidden" value="<%=comentario.getId()%>" class="input-xlarge" name="idcomentario" >

                                    <input type="hidden" value="<%=comentario.getIdDocumento()%>" class="input-xlarge" name="iddocumento" >
                                        <input type="text" value="<%=comentario.getTitulo()%>" class="input-xlarge" name="titulo" >
                                            <label>Fecha</label>
                                            <input type="text" value="<%=comentario.getFecha()%>" class="input-xlarge" name="fecha">
                                                <label>Contenido</label>
                                                <textarea value="Smith" rows="3" class="input-xlarge" name="contenido">
                                                    <%=comentario.getContenido()%>
                                                </textarea>
                                                <br />
                                                <div>
                                                    <input type ="submit" value="Enviar" class="btn btn-primary" style="margin-top: 10px;" />
                                                </div>
                                                </form>
                                                </div>
                                                <a href="LogOut.jsp" class="btn btn-large btn-info">Cerrar Sesion</a>
                                                </div>




                                                </body>
                                                </html>