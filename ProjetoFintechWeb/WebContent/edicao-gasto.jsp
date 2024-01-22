<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Editar Gasto</title>
</head>
<body>
	<div class="container">
        <div class="tittle-entidades"><p>Editar Gasto</p></div>
		
		<form action="gasto" class="form-recebimento" method="post">
        	<input type="hidden" value="editar" name="acao">
			<input type="hidden" value="${gasto.codigoGasto}" name="codigoGasto">
			<div class="form-cadastro-recebimento">
				<img src="./image/VALOR.png" alt="valor"> <input type="text" name="valor" class="form-control-recebimento" value="${gasto.valor }">
			</div>
			<div class="form-cadastro-recebimento">
				<img src="./image/DESCRICAO.png" alt="descricao"> <input type="text" name="descricao" class="form-control-recebimento" value="${gasto.descricao }">
			</div>
			<div class="form-cadastro-recebimento">
				<img src="./image/DATA.png" alt="data_gasto"> <input type="text" name="dataGasto" class="form-control-recebimento" 
				value='<fmt:formatDate value="${gasto.dtGasto.time }" pattern="dd/MM/yyyy"/>'>
			</div>
			<div class="form-cadastro-recebimento">
				<img src="./image/DESCRICAO.png" alt="categoria">  
				<select name="categoria" id="id-genero" class="form-control-gasto">
                    <option value="0" disabled selected>${gasto.categoria }</option>
                    <option value="Aluguel" >Aluguel</option>
                    <option value="Alimentação" >Alimentação</option>
                    <option value="Academia" >Academia</option>
                    <option value="Transporte" >Transporte</option>
                    <option value="Educação" >Educação</option>
                    <option value="Lazer" >Lazer</option>
                    <option value="Outros" >Outros</option>
                </select>
			</div>
			
			<div>
			<input type="submit" value="Salvar" class="salvarEditar">
			<a href="gasto?acao=listar" class="cancelarEditar">Cancelar</a>
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