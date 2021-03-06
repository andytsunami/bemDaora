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
      <title>${instituicao.nome}</title>
      <bd:import-jquery/>
      <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
      <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
      <link href="<c:url value='/resources/css/main.css?version=3'/>" rel="stylesheet" type="text/css">
      <!-- FONT AWESOME -->
      <link rel="stylesheet" href="/bemdahora/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
      <!-- FONT AWESOME -->
      <!--menuzin-->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-route.min.js"></script>
      
      
      
      <!-- Início do Lightbox -->
	  <script src="<c:url value='/resources/jquery/lightbox/js/jquery-1.10.2.min.js'/>"> </script>
      <script src="<c:url value='/resources/jquery/lightbox/js/lightbox-2.6.min.js'/>"> </script>
      <link href="<c:url value='/resources/jquery/lightbox/css/lightbox.css'/>" type="text/css" rel="stylesheet" />
        
        <link href='http://fonts.googleapis.com/css?family=Special+Elite' rel='stylesheet' type='text/css'>
		<script src="<c:url value='/resources/js/alerta.js?v=3'/>"> </script>
		
<!-- Fim do Lightbox -->
   </head>
   <body>
      <div class="container">
         <div id="cont">
            <div class="top-layout">
               <span style="float:left; padding: 16px 0 0 18px; font-size: 20px;"><a href="/bemdahora/voluntario/home/${usuario.id}"><i class="fa fa-arrow-left" aria-hidden="true"></i></a></span>
               <center>
                  <p class="title-page">${instituicao.nome}</p>
               </center>
               <span style="float: right; padding: 0 18px 0 0; margin-top: -20px; font-size: 20px;"><a href="#"><i class="fa fa-cog" aria-hidden="true"></i></a></span>
            </div>
            <div class="bg-company">
            </div>
            
            <c:set value="${agendado ? '' : 'hidden'}" var="hidden"/>       
		        <div class="alerta ${hidden}">
						<table>
							<tr>
								<td><i class="fa fa-clock-o fa-2x" aria-hidden="true"></i></td>
								<td><h3 style="margin-left: 15px;">Sua solicitação está em analize.</h3></td>
							</tr>
						</table>
		        </div>
            <section style="padding:10px;">
               <table style="width: 300px; margin: 0px auto; padding-top: 50px;">
                  <tr>
                     <td>
                     
                     <c:if test="${not empty instituicao.avatar}">
	                        <center><img src="${instituicao.avatarNoJeito}" class="logo-company" width="90" height="90"/></center>
					</c:if>
                     
                     </td>
                  </tr>
                  <tr>
                     <td>
                        <p class="name-profile" style="text-align:center; margin:0; color:#999;">${instituicao.nome}</p>
                     </td>
                  </tr>
               </table>
               <p>${instituicao.sobre}</p>
            </section>
            <br/>
           
            <script type="text/ng-template" id="pages/sobre">
               <div class="intituicoes-proximas">
                <h3 class="title-company">Historia</h3>
               <p>${instituicao.historia}</p>
               <br/>
               <h3 class="title-company">Valores</h3>
               <p>${instituicao.valores}</p>
               </div>
               
            </script>
            
            <script type="text/ng-template" id="pages/vagas">
               <c:forEach items="${vagas}" var="vaga">
            		<div class="vagas-company">
            			<c:if test="${vaga.quantidade > 0}">
                			<a href="/bemdahora/vaga/${vaga.id}" style="text-decoration: none;"><span class="botao-saibamais">SAIBA MAIS</span></a>
                		</c:if>
                		<h3>${vaga.titulo}</h3>
                		<c:if test="${vaga.quantidade > 0}">
                			<span style="color: green">${vaga.quantidade} Vagas</span>
                		</c:if>
                		<c:if test="${vaga.quantidade <= 0}">
                			<span style="color: red">Não há vagas disponiveis</span>
                		</c:if>
               		</div>
            	</c:forEach>
            </script>
            
           
            <script type="text/ng-template" id="pages/fotos">
	            <div class="flex-container" id="galeria">
					<c:forEach items="${instituicao.fotosInstituicao}" var="foto" varStatus="i">
						<c:if test="${i.index <= 9 }">
							<div class="flex-item">
								<a href="<c:url value='/imagem/instituicao/${foto.id}/adm'/>" title="" data-lightbox="galeria">
									<img src="${foto.fotoNoJeito}" width="288" height="288">
								</a>
							</div>
						</c:if>
		            </c:forEach>
	               </div>
            </script>
            <script type="text/ng-template" id="pages/feed">
               <div>
               
                 <h1>mapa</h1>
               
                 <h3>Tem um mapa aqui....</h3>
               
               </div>
               
            </script>
            <div class="menu-company">
               <ul>
                  <li><a href="#/">Sobre</a></li>
                  <li><a href="#/vagas">Vagas</a></li>
                  <li><a href="#/fotos">Fotos</a></li>
                  <li><a href="#/feed">Mapa</a></li>
               </ul>
            </div>
            <div ng-view></div>
            <script src="<c:url value='/resources/js/menu-company.js'/>"> </script>
         </div>
      </div>
   </body>
</html>