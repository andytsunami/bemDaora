<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="bd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Instruções</title>
      <bd:import-jquery/>
      <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
      <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
      <link href="<c:url value='/resources/css/main.css?version=3'/>" rel="stylesheet" type="text/css">
      <!-- FONT AWESOME -->
      <link rel="stylesheet" href="/bemdahora/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
      <!-- FONT AWESOME -->
      <script type="text/javascript">
      $(document).ready(function(){
    	 	
    	  $(".botao-confirmacao").click(function(){
        	  window.location = "/bemdahora/atividade/realizar/${idAtividade}";
          });
    	});
      </script>
      <style type="text/css">
      	.botao-confirmacao{
      		cursor: pointer;
      	}
      </style>
   </head>
   <body>
      <div class="container">
         <div id="cont">
            <section style="padding-top: 30px;">
               <div class="instrucoes">
               	  <h2>Instruções</h2>
                  <p style="text-align: center; font-weight: 600;">Aguarde pela análise da instituição e confirmação para realizar sua doação de horas.</p>
 					<table style="margin-top: 15px;">
                    	<tr>
                        	<td><span>1</span></td>
                            <td><p>Não se esqueça de chegar ao local com antecedência</p></td>
                        </tr>
                        <tr>
                        	<td><span>2</span></td>
                            <td><p>Preencha todos documentos fornecidos pela instituição</p></td>
                        </tr>
                        <tr>
                        	<td><span>3</span></td>
                            <td><p>Esteja com o seus documentos.RG e CPF (rg e cpf)</p></td>
                        </tr>
                        <tr>
                        	<td><span>4</span></td>
                            <td><p>Após a realização de mais uma doação aguarde a confirmação pela instituição</p></td>
                        </tr>
                        <tr>
                        	<td><span>5</span></td>
                            <td><p>Você irá receber os seus agradecimentos através do aplicativo</p></td>
                        </tr>
                        <tr>
                        	<td><span>6</span></td>
                            <td><p>Suas Badges e pontos correspondentes a sua ação</p></td>
                        </tr>
                        <tr>
                        	<td><span>7</span></td>
                            <td><p>Obrigado!</p></td>
                        </tr>
                    </table>
                  <br/>
                  <center><input type="button" value="CONFIRMAR" class="botao-confirmacao"></center>
				  <br/>
               </div><!--card-perfil-->
            </section>
         </div><!--cont-->
      </div><!--container-->
   </body>
</html>