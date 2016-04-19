<%-- 
    Document   : newjsp
    Created on : Apr 19, 2016, 11:55:18 AM
    Author     : Pgz
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="CSS/memberPageCSS.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member Register</title>
    </head>
    <body center>
        <h1>Member Page</h1>
        <div id="cadMember">
            <form name="CadMember" action="CadJogador" method="POST" ><br/><br/>
                Nome Completo <br/>
                <input type="text" name="txtNome" value="" size="20" /><br/> <br/>
                Data Nascimento<br/>
                <input type="text" name="txtNascimento" value="" size="20" /> <br/><br/>
                Endereço<br/>
                <input type="text" name="txtEndereco" value="" size="50" /> <br/><br/>
                CPF<br/>
                <input type="text" name="txtCpf" value="" size="20" /> <br/><br/>
                RG<br/>
                <input type="text" name="txtRg" value="" size="20" /> <br/><br/>
                Telefone<br/>
                <input type="text" name="txtTelefone" value="" size="20" /> <br/><br/>
                Email<br/>
                <input type="text" name="txtEmail" value="" size="20" /><br/><br/>
                Nivel de acesso<br/>
                <input type="text" name="txtAcesso" value="" size="20" /><br/><br/>
                <div id="enterBtn"><input type="submit" value="Enter" name="btnLogin" /></div>  
            </form> 
        </div>
    </body>
</html>
