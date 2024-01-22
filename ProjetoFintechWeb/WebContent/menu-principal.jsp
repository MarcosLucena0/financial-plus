<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/style.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>MenuPrincipal</title>
</head>
<body>
<div class="container">
        <div class="nomedousuario"><p>${user }</p></div>
        <a href="login" class="btn btn-outline-primary my-2 my-sm-0">Sair</a>
        <div class="perfil"><img src="image/PERFIL-MENOR.png" alt=""></div>
        
                <div class="saldo-container">
                    <p>Saldo Total</p>                  
                </div>
                  <div class="valor-container">           
                    <input type="text"  value="R$:   "/>
                </div>
            
                <div class="transacoes-container">
                    <p class="center-align">Transações</p>
                    <select id="meses">
                        <option value="janeiro">Janeiro</option>
                        <option value="fevereiro">Fevereiro</option>
                        <option value="marco">Março</option>
                        <option value="abril">Abril</option>
                        <option value="maio">Maio</option>
                        <option value="junho">Junho</option>
                        <option value="julho">Julho</option>
                        <option value="agosto">Agosto</option>
                        <option value="setembro">Setembro</option>
                        <option value="outubro">Outubro</option>
                        <option value="novembro">Novembro</option>
                        <option value="dezembro">Dezembro</option>
                    </select>
                </div>
            
                <div class="arrow-container">
                    <div>
                        <span class="arrow-green"></span>
                        <input type="text" id="valorVerde" value="R$" class="input-style" />
                    </div>
                    <div>
                        <span class="arrow-red"></span>
                        <input type="text" id="valorVermelho" value="R$" class="input-style" />
                    </div>
                </div>

        <div class="resumo">
            <div class="resumo-text">Resumo Financeiro</div>
            <input class="input-field" type="text" placeholder="gasto n°1">
            <input class="input-field" type="text" placeholder="gasto n°2">
            <input class="input-field" type="text" placeholder="recebimento n°1">
            <input class="input-field" type="text" placeholder="recebimento n°2">
        </div>

        <div class="linhadivisao"></div>

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