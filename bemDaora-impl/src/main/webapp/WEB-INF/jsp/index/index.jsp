<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<meta name="description" content="">
	  	<meta name="author" content="">
	  	<link rel="manifest" href="<c:url value='/resources/js/manifest.json'/>">
	  	
	  	<!-- Add to homescreen for Chrome on Android -->
	    <meta name="mobile-web-app-capable" content="yes">
	    <link rel="icon" sizes="192x192" href="/bemdahora/resources/images/favicon.png">
	    <meta name="theme-color" content="#007dbe">
	
	    <!-- Add to homescreen for Safari on iOS -->
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="apple-mobile-web-app-capable" content="yes">
	    <meta name="apple-mobile-web-app-title" content="Bem da Hora">
	    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
	    <link rel="apple-touch-icon-precomposed" href="/bemdahora/resources/images/favicon.png">
	
	    <!-- Tile icon for Win8 (144x144 + tile color) -->
	    <meta name="msapplication-TileImage" href="/bemdahora/resources/images/favicon.png">
	    <meta name="msapplication-TileColor" content="#007dbe">
	
		<title>Bem vindo ao Bemdahora</title>
		  
		<bd:import-jquery/>
		  <script src="<c:url value='/resources/js/contextAction.js'/>"></script>
		  <script src="<c:url value='/resources/js/classie.js'/>"></script>
		  <script src="/bemdahora/resources/js/masked.js"></script>
		  <script src="/bemdahora/resources/js/jquery.numeric.js"></script>
		  
		  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		  <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
		  
		  <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css">
		  <!-- FONT AWESOME -->
		  
		  <link rel="stylesheet" href="<c:url value='/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css'/>">
		  <!-- FONT AWESOME -->
	
	    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/normalize.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/demo.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/set1.css'/>" />
		<script type="text/javascript" src="<c:url value='/resources/js/index.js'/>"></script>
	</head>
	<body>
		<form method="post" id="form">
			<input type="hidden" id="rede" name=""/>
			 <div style="max-width: 600px; margin: auto; box-shadow: rgba(0, 0, 0, 0.1) 1px 1px 7px;">
				<div id="cont" style="bottom: 30px;padding-top:50px;">
			    	<center><img src="<c:url value='/resources/images/logo.png'/>" /></center>
						<section class="" style="margin:auto; max-width: 348px; min-width: 300px; width: 100%;">
							<span class="input input--hoshi">
								<input class="input__field input__field--hoshi" type="text" id="email" name="login.email"/>
								<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-4">
									<span class="input__label-content input__label-content--hoshi">E-MAIL</span>
								</label>
							</span>
							<span class="input input--hoshi">
								<input class="input__field input__field--hoshi" type="password" id="senha" name="login.senha"/>
								
								<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-5">
									<span class="input__label-content input__label-content--hoshi">SENHA</span>
								</label>
							</span>
			                <span class="input input--hoshi">
			                <center><input type="button" value="ENTRAR" class="botao" id="entrar"></center>
			                </span>
						</section>
			    	<center><input type="button" value="ENTRAR COM FACEBOOK" class="botao" style="background:#3B5998" id="fb-login"></center>
			        <br/>
			        <center><input type="button" value="ENTRAR COM GOOGLE+" class="botao" style="background:#C20807"></center>
			        <br/>
			        <table class="cadastro-esqueci-senha">
			        	<tr>
			            	<td style="border-right: 1px solid #999999; padding-right:  20px;"><a href="/bemdahora/usuario/cadastro">CADASTRAR</a></td>
			                <td style="padding-left: 34px;"><a href="#">ESQUECI A SENHA</a></td>
			            </tr>
			        </table>
				</div>
			  </div>
		</form>
	</body>
</html>