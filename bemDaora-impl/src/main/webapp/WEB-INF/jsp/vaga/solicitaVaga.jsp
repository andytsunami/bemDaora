<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html ng-app="myApp">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Solicitação</title>
      <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
      <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
      <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css">
      <!-- FONT AWESOME -->
      <link rel="stylesheet" href="/bemdahora/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
      <!-- FONT AWESOME -->
      <!--menuzin-->
      
      
      <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-route.min.js"></script>
      
      <bd:import-jquery/>
      
      <link rel="stylesheet" type="text/css" href="/bemdahora/resources/css/normalize.css" />
      <link rel="stylesheet" type="text/css" href="/bemdahora/resources/css/demo.css" />
	  <link rel="stylesheet" type="text/css" href="/bemdahora/resources/css/set1.css" />
      
      <script src="<c:url value='/resources/js/solicitaVaga.js'/>"> </script>
      <style type="text/css">
      	#confirma{
      		cursor: pointer;
      	}
      </style>
   </head>
   <body>
      <div class="container">
         <div id="cont">
            <div class="top-layout">
               <span style="float:left; padding: 16px 0 0 18px; font-size: 20px;"><a href="/bemdahora/instituicao/${vaga.instituicao.id}"><i class="fa fa-arrow-left" aria-hidden="true"></i></a></span>
               <center>
                  <p class="title-page">${usuario.nome}</p>
               </center>
               <span style="float: right; padding: 0 18px 0 0; margin-top: -20px; font-size: 20px;"><a href="#"><i class="fa fa-cog" aria-hidden="true"></i></a></span>
            </div>
            <div class="bg-company">
            </div>
            <section style="padding:10px;">
               <table style="width: 300px; margin: 0px auto; padding-top: 50px;">
                  <tr>
                     <td>
                        <center><img src="${vaga.instituicao.avatarNoJeito}" class="logo-company"/></center>
                     </td>
                  </tr>
               </table>
            </section>
            <section>
               <div class="intituicoes-proximas">
               		<input type="hidden" id="idVoluntario" value="${idVoluntario}">
               		<input type="hidden" id="idVaga" value="${vaga.id}">
               		<input type="hidden" id="idInstituicao" value="${vaga.instituicao.id}">
                  <h3>Escolha a melhor data e hora:</h3>
                  <span class="input input--hoshi">
                  <input class="input__field input__field--hoshi" type="datetime-local" id="dataAgendada"/>
                  <label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-5">
                  <span class="input__label-content input__label-content--hoshi">Data e horario pretendido</span>
                  </label>
                  </span>
                  <br/>
                  <h4 style="color:#378DB7;">Termos de responsabilidade</h4>
                  <p>Ao continuar declaro que li e concordo com os termos de responsabilidade</p>
                  <br/><br/>
                  <center><div style="text-decoration: none;" id="confirma"><span class="botao-confirma">CONFIRMAR</span></div></center>
                  <br/>
               </div>
            </section>
         </div>
         <script src="<c:url value='/resources/js/menu-company.js'/>"> </script>
      </div>
      <script src="<c:url value='/resources/js/dragend.js'/>"> </script>
   </body>
</html>