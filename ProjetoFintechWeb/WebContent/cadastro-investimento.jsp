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
    <title>CadastroInvestiemntos</title>
</head>
<body>
	<div class="container">
        <div class="tittle-entidades"><p>Novo Investimento</p></div>
        
            <div class="button-listagem">
                <a href="investimento?acao=listar">Listagem</a>
            </div>
            
         <c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		
		<form action="investimento" class="form-listagem" method="post">
		<input type="hidden" value="cadastrar" name="acao">
            <div class="form-cadastro-gasto">
                <img src="./image/CATEGORIA.png" alt="tp-investimento">
                <select name="tipoInvestimento" id="id-investimento" class="form-control-recebimento">
                    <option value="0" disabled selected>Tipo de Investimento</option>
                    <option value="CDB" >CDB</option>
                    <option value="Tesouro Direto" >Tesouro Direto</option>
                    <option value="Poupança" >Poupança</option>
                    <option value="FIIS" >FIIS</option>
                    <option value="Ações" >Ações</option>
                    <option value="Outro" >Outros</option>
                </select>
            </div>
            <div class="form-cadastro-investimento">
                <img src="./image/CATEGORIA.png" alt="ap-financeira">
                <input type="text" name="aplicacaoFinanceira" class="form-control-investimento" placeholder="Aplicação Financeira: ">
            </div>
            <div class="form-cadastro-gasto">
                <img src="./image/DESCRICAO.png" alt="nm-banco">
                <select name="nomeBanco" id="id-banco" class="form-control-recebimento">
                    <option value="0" disabled selected>Nome do Banco</option>
                    <option value="Nubank" >Nubank</option>
                    <option value="Rico" >Rico</option>
                    <option value="PagBank" >PagBank</option>
                    <option value="Caixa" >Caixa</option>
                    <option value="Inter" >Inter</option>
                    <option value="MercadoPago" >MercadoPago</option>
                    <option value="Santander" >Santander</option>
                    <option value="Bradesco" >Bradesco</option>
                    <option value="Banco do Brasil" >Banco do Brasil</option>
                    <option value="Itaú" >Itaú</option>
                    <option value="Outros" >Outros</option>
                </select>
            </div>
            <div class="form-cadastro-gasto">
                <img src="./image/VALOR.png" alt="valor">
                <input type="text" name="valor" class="form-control-investimento" placeholder="Valor: ">
            </div>
            <div class="form-cadastro-gasto">
                <img src="./image/DATA.png" alt="dt-investimento">
                <input type="text" name="dataInvestimento" class="form-control-recebimento" placeholder="Data de Investimento: ">
            </div>
            <div class="form-cadastro-gasto">
                <img src="./image/DATA.png" alt="dt-vencimento">
                <input type="text" name="dataVencimento" class="form-control-recebimento" placeholder="Data de Vencimento: ">
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