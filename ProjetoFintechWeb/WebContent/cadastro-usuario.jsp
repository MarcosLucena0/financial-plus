<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/style.css" rel="stylesheet">
<title>Fintech</title>
</head>
<body>
	<div class="container">
        <div class="tittle"><p>Cadastrar Usuário</p></div>
       	<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
        <div class="logoUsuario"><img src="image/PERFIL-MAIOR.png" alt=""></div>

            <form action="usuario" class="form" method="post">
            <input type="hidden" value="cadastrar" name="acao">
                <div class="form-cadastro">
                    <input type="text" name="nome" class="form-control" placeholder="Nome: ">
                </div>
                <div class="form-cadastro">
			        <input type="text" name="nascimento"  class="form-control" placeholder="Data de Nascimento">
                </div>
                <div class="form-cadastro">
                    <select name="genero" id="id-genero" class="form-control">
                        <option value="0" disabled selected>Gênero</option>
                        <option value="Masculino" >Masculino</option>
                        <option value="Feminino" >Feminino</option>
                    </select>
                </div>
                <div class="form-cadastro">
                    <input type="email" name="email" class="form-control" placeholder="Email: ">
                </div>
                <div class="form-cadastro">
                    <input type="password" name="senha"  class="form-control" placeholder="Senha: ">
                </div>
            
        		<div class="button">
        			<button class="button-cadastro" type="submit">Cadastrar</button>
            		<a class="button-voltar" href="login.jsp">Voltar</a>
       			 </div>
       		</form>
    </div>
</body>
</html>