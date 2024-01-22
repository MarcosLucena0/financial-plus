<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Editar Objetivo Financeiro</title>
</head>
<body>
	<div class="container">
        <div class="tittle-entidades"><p>Editar Objetivo Financeiro</p>
        </div>
		
		<form action="objFinanceiro" class="form-recebimento" method="post">
        	<input type="hidden" value="editar" name="acao">
			<input type="hidden" value="${objFinanceiro.codigoObjFinanceiro}" name="codigoObjFinanceiro">
			<div class="form-cadastro-recebimento">
				<img src="./image/VALOR.png" alt="nome"> <input type="text" name="nomeObjFinanceiro" class="form-control-recebimento" value="${objFinanceiro.nomeObjFinanceiro}">
			</div>
			<div class="form-cadastro-recebimento">
				<img src="./image/VALOR.png" alt="valor"> <input type="text" name="valor" class="form-control-recebimento" value="${objFinanceiro.valor}">
			</div>
			<div class="form-cadastro-recebimento">
				<img src="./image/DESCRICAO.png" alt="descricao"> <input type="text" name="descricao" class="form-control-recebimento" value="${objFinanceiro.descricao}">
			</div>
			<div class="form-cadastro-recebimento">
				<img src="./image/DATA.png" alt="data_ObjFinanceiro"> <input type="text" name="dataObjFinanceiro" class="form-control-recebimento" 
				value='<fmt:formatDate value="${objFinanceiro.dataObjFinanceiro.time }" pattern="dd/MM/yyyy"/>'>
			</div>
			
			<div>
			<input type="submit" value="Salvar" class="salvarEditar">
			<a href="objFinanceiro?acao=listar" class="cancelarEditar">Cancelar</a>
			</div>
			
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