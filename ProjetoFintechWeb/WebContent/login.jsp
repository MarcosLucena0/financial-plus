<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="css/style.css" rel="stylesheet">
    <title>Login</title>
</head>

<body>
    <div class="container">
       
        <img class="logo" src="image/logo.png" alt="logo">

        
        <div class="welcome">
            <div class="welcome-text">Bem-Vindo</div>
          
            <span class="navbar-text text-danger" style="margin-right:10px" >
				${erro }
			</span>	
               <form action="login" method="post">
                <i id="email" class="far fa-envelope"></i>
                <input class="input-field" type="email" name="email" placeholder="Email">
                <i id="senha" class="fa-light fa-lock"></i>
                <input class="input-field" type="password" name="senha" placeholder="Senha">
                <button class="login-button" type="submit">Login</button>
                <a class="signup-button" href="cadastro-usuario.jsp">Cadastre-se</a>
            </form>
            
        </div>

        
        <div class="login-text">
            Faça seu login automaticamente
        </div>

        <div class="social-icons">
            <img src="image/FACEBOOK.png" alt="Facebook">
            <img src="image/GOOGLE.png" alt="Google">
        </div>
    </div>
</body>

</html>
