<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>perfil</title>
      <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
      <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
      <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css">
      <!-- FONT AWESOME -->
      <link rel="stylesheet" href="/bemdahora/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
      <!-- FONT AWESOME -->
   </head>
   <body>
      <div class="container">
         <div id="cont">
            <div class="top-layout">
               <span style="float:left; padding: 16px 0 0 18px; font-size: 20px;">
                    <a href="/bemdahora/voluntario/home/${atividade.voluntario.id}">
                    	<i class="fa fa-arrow-left" aria-hidden="true"></i>
                    </a>
               </span>
               <center><p class="title-page">Confirmação</p></center>
               <span style="float: right; padding: 0 18px 0 0; margin-top: -20px; font-size: 20px;">
               		<a href="#">
                    	<i class="fa fa-cog" aria-hidden="true"></i>
                    </a>
               </span>
            </div><!--top-layout-->
            
            
            <section class="perfil-timeline" style="height:100vh; padding-top: 30px;">
               <div class="card-perfil" style="max-width:350px; margin:auto">
               	  <table class="table-confirma">
                     <tr>
                        <td><img class="timeline-img-profile" src="${atividade.vaga.instituicao.avatarNoJeito}" width="48" height="48"/></td>
                        <td><span class="timeline-txt-profile" style="text-transform: uppercase;">${vaga.instituicao.nome}</span></td>
                     </tr>
               	  </table>
                  <table class="table-confirma">
                     <tr>
                        <td><h5>Vaga:</h5></td>
                        <td><p>${atividade.vaga.titulo}</p></td>
                     </tr>
                     <tr>
                        <td><h5>Data:</h5></td>
                        <td><p><fmt:formatDate pattern="dd/MM/yyyy" value="${atividade.dataAgendada}" /></p></td>
                     </tr>
                     <tr>
                        <td><h5>Horário:</h5></td>
                        <td><p><fmt:formatDate pattern="HH:mm" value="${atividade.dataAgendada}" /> às 18:00</p></td>
                     </tr>
                     <tr>
                        <td><h5>Local:</h5></td>
                        <td><p>${atividade.vaga.instituicao.endereco}</p></td>
                     </tr>
               	  </table>
                  <br/>
                  <center><input type="button" value="CONFIRMAR E VER INSTRUÇÕES" class="botao-confirmacao"></center>
                  <br/>
                  <center><input type="button" value="CANCELAR" class="botao-cancelamento"></center>
                  <br/>
               </div><!--card-perfil-->
               
               
            </section>
            
         </div><!--cont-->
      </div><!--container-->
      
   </body>
</html>