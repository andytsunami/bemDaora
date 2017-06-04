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
      <title>${vaga.titulo}</title>
      <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
      <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
      <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css">
      <bd:import-jquery/>
      <!-- FONT AWESOME -->
      <link rel="stylesheet" href="/bemdahora/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
      <!-- FONT AWESOME -->
      <!--menuzin-->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-route.min.js"></script>
   </head>
   <body>
      <div class="container">
         <div id="cont">
            <div class="top-layout">
               <span style="float:left; padding: 16px 0 0 18px; font-size: 20px;"><a href="<c:url value='/instituicao/${vaga.instituicao.id}#/vagas'/>"><i class="fa fa-arrow-left" aria-hidden="true"></i></a></span>
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
                        <center><img src="${vaga.instituicao.avatarNoJeito}" class="logo-company" width="64" height="64"/></center>
                     </td>
                  </tr>
               </table>
            </section>
            <section>
               <div class="intituicoes-proximas">
                  <h3 class="title-trab">${vaga.titulo}</h3>
                  <p>${vaga.descricao}</p>
                  
                  <br/>
                  <center><a href="<c:url value='/vaga/solicita/${vaga.id}/${usuario.id}'/>" style="text-decoration: none;"><span class="botao-confirma">SOLICITAR</span></a></center>
                  <br/>
               </div>
            </section>
         </div>
      </div>
   </body>
</html>