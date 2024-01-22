<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<script type="text/javascript" src="resources/js/bootstrap.min"></script>
	<script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/style.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>CadastroObjetivoFinanceiro</title>
</head>
<body>
	<div class="container">
        <div class="tittle-entidades"><p>Novo Objetivo Financeiro</p> </div>
		<div class="button-listagem">
                <a href="objFinanceiro?acao=listar">Listagem</a>
        </div>
        <c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
        <form action="objFinanceiro" class="form-listagem" method="post">
        <input type="hidden" value="cadastrar" name="acao">
				<div class="form-cadastro-objetivo">
					<img src="./image/CATEGORIA.png" alt="nomeObjetivo"> <input
						type="text" name="nomeObjFinanceiro" class="form-control-objetivo"
						placeholder="Objetivo Financeiro (ex: casa, carro, viagem): ">
				</div>
				<div class="form-cadastro-objetivo">
					<img src="./image/VALOR.png" alt="valor"> <input type="text"
						name="valor" class="form-control-objetivo" placeholder="Valor: ">
				</div>
				<div class="form-cadastro-objetivo">
					<img src="./image/DESCRICAO.png" alt="descricao"> <input
						type="text" name="descricao" class="form-control-recebimento"
						placeholder="Descrição: ">
				</div>
				<div class="form-cadastro-objetivo">
					<img src="./image/DATA.png" alt="data_objetivo"> <input
						type="text" name="dataObjFinanceiro" class="form-control-objetivo"
						placeholder="Data do Objetivo: ">
				</div>

				<button class="button-cadastro" type="submit">Cadastrar</button>
		</form>
        
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