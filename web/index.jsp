<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    </head>
    <body style="margin-left: 311px; margin-top: 133px;">

        
       

        <form action="login" method="post" style="margin-left: -12px; margin-top: 30px; padding-left: 40px; width: 625px;">

            <label for="nombre"> Nombre de usuario </label>
            <input id="nombre" style="margin-bottom: 15px;" type="text" name="userId" size="30" />

            <label for="pass">Password:</label>
            <input id="pass" style="margin-bottom: 15px;" type="password" name="password" size="30" />

            <label for="summit"></label>
            <input class="btn btn-primary" id="summit" style="clear: left; height: 32px; font-size: 13px; margin-left: 44px;  width: 22%;" type="submit" name="commit" value="Sign In" />
        </form>


    
    </body>
</html>