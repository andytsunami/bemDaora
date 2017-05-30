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
      <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
      <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
      <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css">
      <!-- FONT AWESOME -->
      <link rel="stylesheet" href="/bemdaora/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
      <!-- FONT AWESOME -->
      <!--menuzin-->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-route.min.js"></script>
      
      
      
      <!-- Início do Lightbox -->
	  <script src="<c:url value='/resources/jquery/lightbox/js/jquery-1.10.2.min.js'/>"> </script>
      <script src="<c:url value='/resources/jquery/lightbox/js/lightbox-2.6.min.js'/>"> </script>
      <link href="<c:url value='/resources/jquery/lightbox/css/lightbox.css'/>" type="text/css" rel="stylesheet" />
        
        <link href='http://fonts.googleapis.com/css?family=Special+Elite' rel='stylesheet' type='text/css'>

<!-- Fim do Lightbox -->
   </head>
   <body>
      <div class="container">
         <div id="cont">
            <div class="top-layout">
               <span style="float:left; padding: 16px 0 0 18px; font-size: 20px;"><a href="index.html"><i class="fa fa-arrow-left" aria-hidden="true"></i></a></span>
               <center>
                  <p class="title-page">PERFIL</p>
               </center>
               <span style="float: right; padding: 0 18px 0 0; margin-top: -20px; font-size: 20px;"><a href="#"><i class="fa fa-cog" aria-hidden="true"></i></a></span>
            </div>
            <div class="bg-company">
            </div>
            <section style="padding:10px;">
               <table style="width: 300px; margin: 0px auto; padding-top: 50px;">
                  <tr>
                     <td>
                     
                     <c:if test="${not empty instituicao.avatar }">
	                        <center><img src="<c:url value='/avatar/instituicao/${instituicao.id}'/>" class="logo-company" width="120"/></center>
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
               <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut pellentesque purus. Sed fermentum massa vel odio dignissim, sed bibendum nulla porttitor</p>
               <br/>
               <h3 class="title-company">Valores</h3>
               <p>Sed fermentum massa vel odio dignissim, sed bibendum nulla porttitor</p>
               </div>
               
            </script>
            <script type="text/ng-template" id="pages/vagas">
               <div class="vagas-company">
                <a href="job.html" style="text-decoration: none;"><span class="botao-saibamais">SAIBA MAIS</span></a>
                <h3>Baba de Criança</h3>
                <span style="color: green">3 Vagas</span>
               </div>
               
               <div class="vagas-company">
                <a href="job.html" style="text-decoration: none;"><span class="botao-saibamais">SAIBA MAIS</span></a>
                <h3>Baba de Criança</h3>
                <span style="color: red">Não há vagas</span>
               </div>
               
               <div class="vagas-company">
                <a href="job.html" style="text-decoration: none;"><span class="botao-saibamais">SAIBA MAIS</span></a>
                <h3>Baba de Criança</h3>
                <span style="color: green">3 Vagas</span>
               </div>
            </script>
            <script type="text/ng-template" id="pages/fotos">
               <div class="flex-container" id="">
					<div class="flex-item">
						<a href="imgs/serv1.jpg" title="" data-lightbox="galeria">
							<img src="imgs/serv1.jpg">
						</a>
					</div>
					<div class="flex-item">
						<a href="imgs/serv2.jpg" title="" data-lightbox="galeria">
							<img src="imgs/serv2.jpg">
						</a>
					</div>
					<div class="flex-item">
						<a href="imgs/serv3.jpg" title="" data-lightbox="galeria">
							<img src="imgs/serv3.jpg">
						</a>
					</div>
               </div>
			   
			   <div class="flex-container" id="">
					<div class="flex-item">
						<a href="imgs/serv4.jpg" title="" data-lightbox="galeria">
							<img src="imgs/serv4.jpg">
						</a>
					</div>
					<div class="flex-item">
						<a href="imgs/serv5.jpg" title="" data-lightbox="galeria">
							<img src="imgs/serv5.jpg">
						</a>
					</div>
					<div class="flex-item">
						<a href="imgs/serv1.jpg" title="" data-lightbox="galeria">
							<img src="imgs/serv1.jpg">
						</a>
					</div>
               </div>
			   
			   <div class="flex-container" id="">
					<div class="flex-item">
						<a href="imgs/serv1.jpg" title="" data-lightbox="galeria">
							<img src="imgs/serv1.jpg">
						</a>
					</div>
					<div class="flex-item">
						<a href="imgs/serv2.jpg" title="" data-lightbox="galeria">
							<img src="imgs/serv2.jpg">
						</a>
					</div>
					<div class="flex-item">
						<a href="imgs/serv3.jpg" title="" data-lightbox="galeria">
							<img src="imgs/serv3.jpg">
						</a>
					</div>
               </div>
            </script>
            <script type="text/ng-template" id="pages/feed">
               <div>
               
                 <h1>feed</h1>
               
                 <h3>{{message}}</h3>
               
               </div>
               
            </script>
            <div class="menu-company">
               <ul>
                  <li><a href="#/">Sobre</a></li>
                  <li><a href="#/vagas">Vagas</a></li>
                  <li><a href="#/fotos">Fotos</a></li>
                  <li><a href="#/feed">Feed</a></li>
               </ul>
            </div>
            <div ng-view></div>
            <script src="js/menu-company.js"></script>
         </div>
      </div>
      <script type="text/javascript" src="jquery.min.js"></script>
      <script type="text/javascript" src="dragend.js"></script>
      
   </body>
</html>