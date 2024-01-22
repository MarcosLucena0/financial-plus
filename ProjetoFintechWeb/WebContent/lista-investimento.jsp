<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="css/style.css" rel="stylesheet">

	<script type="text/javascript" src="resources/js/bootstrap.min"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <title>Editar Investimento</title>
</head>
<body>
	<div class="container">
        <div class="tittle-entidades"><p>Listagem Investimento</p></div>


		<div class="listagem-entidades">
            <p>Investimento no período</p>
            <select name="Mes" id="id-mes" class="meses">
                <option value="0" disabled selected>Mes</option>
                <option value="1">Janeiro</option>
                <option value="1">Fevereiro</option>
                <option value="1">Março</option>
                <option value="1">Abril</option>
                <option value="1">Maio</option>
                <option value="1">Junho</option>
                <option value="1">Julho</option>
                <option value="1">Agosto</option>
                <option value="1">Setembro</option>
                <option value="1">Outubro</option>
                <option value="1">Novembro</option>
                <option value="1">Dezembro</option>
            </select>
            <div class="lista-container">           
                    <input type="text"  placeholder="R$:   "/>
             </div>
            <p>Investimento total do mes</p>
        </div>
        
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<div id="tabela">
		<table class="table table-striped">
			<tr class="cabecalho">
				<th>Tipo de Investimento</th>
				<th>Aplicação Financeira</th>
				<th>Banco</th>
				<th>Valor</th>
				<th>Data do Investimento</th>
				<th>Data do Vencimento</th>
				<th></th>
			</tr>
			<c:forEach items="${investimentos}" var="i">
				<tr>
					<td>${i.tipoInvestimento}</td>
					<td>${i.aplicacaoFinanceira}</td>
					<td>${i.nomeBanco}</td>
					<td>${i.valor}</td>
					<td>
						<fmt:formatDate value="${i.dataInvestimento.time }" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<fmt:formatDate value="${i.dataVencimento.time }" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<c:url value="investimento" var="link">
							<c:param name="acao" value="abrir-form-edicao"/>
							<c:param name="codigoInvestimento" value="${i.codigoInvestimento}"/>
						</c:url>
						<a class="editar" href="${link}">Editar</a>
						<button type="button" class="excluir" data-toggle="modal" data-target="#excluirModal" onclick="codigoExcluir.value = ${i.codigoInvestimento}">
  							Excluir
						</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>

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
    
    <!-- Modal -->
		<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Deseja realmente excluir o
						gasto?</div>
					<div class="modal-footer">
						<form action="investimento" method="post">
  							<input type="hidden" name="acao" value="excluir"> 
							<input type="hidden" name="codigoInvestimento" id="codigoExcluir">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancelar</button>
							<button type="submit" class="btn btn-danger">Excluir</button>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>