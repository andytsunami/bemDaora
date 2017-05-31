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
	
	<title>cadastro</title>
	
	<bd:import-estilos/>
	
	<script type="text/javascript" src="<c:url value='/resources/js/cadastroUsuario.js'/>"></script>
	</head>
	<body>
		<form id="form" method="post">
			<input type="hidden" name="" value="VOL">
			<input type="hidden" id="rede" name=""/>
			<div style="max-width: 600px; margin: auto; box-shadow: rgba(0, 0, 0, 0.1) 1px 1px 7px;">
				<div id="cont" style="bottom: 30px; padding-top: 50px;">
					<center>
						<h3>CADASTRO</h3>
					</center>
					<section class="" style="margin: auto; max-width: 348px; min-width: 300px; width: 100%;">
		
					<span class="input input--hoshi"> 
						<input class="input__field input__field--hoshi" type="text" id="nome" name="usuario.nome" /> 
						<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-4">
							<span class="input__label-content input__label-content--hoshi">Nome</span>
						</label>
					</span> 
					<span class="input input--hoshi"> 
					
					<input class="input__field input__field--hoshi" type="text" id="email" name="usuario.email"/>
					<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-5">
						<span class="input__label-content input__label-content--hoshi">E-mail</span>
					</label>
		
						</span> <span class="input input--hoshi"> 
						
						<input class="input__field input__field--hoshi" type="password" id="senha" name="usuario.senha"/> 
						<label class="input__label input__label--hoshi input__label--hoshi-color-1"	for="input-5">
							<span class="input__label-content input__label-content--hoshi">Senha</span>
						</label>
		
						</span> <span class="input input--hoshi"> 
		
						<input class="input__field input__field--hoshi" type="text" id="idade" name="usuario.idade"/> 
						<label class="input__label input__label--hoshi input__label--hoshi-color-1"
							for="input-5"> 
							<span class="input__label-content input__label-content--hoshi">Idade</span>
		
						</label>
		
						</span> <span class="input input--hoshi">
						<center>
							<input type="button" value="CADASTRAR" class="botao" id="cadastrar">
						</center>
	
					</span>
	
				</section>
	
				<section class=""
					style="margin: auto; max-width: 348px; min-width: 300px; width: 100%;">
					<center>OU</center>
					<br />
	
					<center>
						<input type="button" value="ENTRAR COM FACEBOOK" class="botao"
							style="background: #3B5998" id="fb-login">
					</center>
	
					<br />
	
					<center>
						<input type="button" value="ENTRAR COM GOOGLE+" class="botao"
							style="background: #C20807">
					</center>
	
					<br /> <a href="/bemdahora"><p style="font-size:12px; color: #999999; text-align: center;"> <i class="fa fa-arrow-left" aria-hidden="true"></i>
	 VOLTAR</p></a>
				</section>
	
	
			</div>
		</div>
		</form>
	</body>
</html>