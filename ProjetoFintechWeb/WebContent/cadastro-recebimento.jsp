<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<script type="text/javascript" src="resources/js/bootstrap.min"></script>
	<script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/style.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>CadastroRecebimentos</title>
</head>
<body>
	<div class="container">
        <div class="tittle-entidades"><p>Novo Recebimento</p></div>

        <div class="button-listagem">
            <a href="recebimento?acao=listar">Listagem</a>
        </div>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
        <form action="recebimento" class="form-recebimento" method="post">
        <input type="hidden" value="cadastrar" name="acao">
			<div class="form-cadastro-recebimento">
				<img src="./image/VALOR.png" alt="valor"> <input type="text" name="valor" class="form-control-recebimento" placeholder="Valor: ">
			</div>
			<div class="form-cadastro-recebimento">
				<img src="./image/DESCRICAO.png" alt="descricao"> <input type="text" name="descricao" class="form-control-recebimento" placeholder="Descrição: ">
			</div>
			<div class="form-cadastro-recebimento">
				<img src="./image/DATA.png" alt="data_recebimento"> <input type="text" name="dataRecebimento" class="form-control-recebimento" placeholder="Data de Recebimento: ">
			</div>
		
            <button class="button-cadastro" type="submit">Cadastrar</button>

        </form>

        <hr>

        <form action="menu-principal" method="post">
        <div class="meus-botoes">
           
            <a href="menu-principal.jsp">
                <img src="image/RESUMO.png" alt="Ícone 1"> Resumo
            </a>
            <a href="cadastro-gasto.jsp">
                <img src="image/GASTOS.png" alt="Ícone 2"> Gastos
            </a>
            <a href="cadastro-recebimento.jsp">
                <img src="image/RECEBIMENTOS.png" alt="Ícone 3"> Recebimentos
            </a>
            <a href="cadastro-investimento.jsp">
                <img src="image/INVESTIMENTOS.png" alt="Ícone 4"> Investimentos
            </a>
            <a href="cadastro-objetivofinanceiro.jsp">
                <img src="image/OBJFINANCEIRO.png" alt="Ícone 5">ObjFinanceiro
            </a>
        </div>
        </form> 

    </div>

</body>
</html>