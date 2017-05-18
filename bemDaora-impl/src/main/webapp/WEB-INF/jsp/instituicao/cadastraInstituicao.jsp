<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<meta name="description" content="">
		<meta name="author" content="remembr">
		<title>cadastro de instituição</title>
		
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/normalize.css'/>">
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/materialize.min.css'/>">
		<script type="text/javascript" src="<c:url value='/resources/jquery/jquery-1.12.4.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/materialize.min.js'/>"></script>
		
		<script type="text/javascript" src="<c:url value='/resources/js/cadastraInstituicao.js'/>"></script>
		
		<style>
			body{
				margin-left: 25%;
			}
		</style>
		
	</head>
	<body>
		<h1>Cadastro de Instituição</h1>
		<div class="row">
			<form method="post" id="form" enctype="multipart/form-data" class="col s12">
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.nome" id="nome" class="validate"/>
						<label for="nome">Nome contato</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.razaoSocial" id="razaoSocial" class="validate"/>
						<label for="razaoSocial">Razão Social</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.email" class="validate" id="email"/>
						<label for="email">Email</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.cnpj" class="validate" id="cnpj"/>
						<label for="cnpj">Nome CNPJ</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<textarea name="instituicao.sobre" class="materialize-textarea" id="sobre"></textarea>
						<label for="sobre">Sobre</label>
					</div>				
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.endereco" class="validate" id="endereco"/>
						<label for="endereco">Endereco</label>
					</div>				
				</div>
				<div class="row">
					<div class="file-field input-field col s6">
						<div class="btn">
							<span>Avatar</span>						
							<input type="file" name="avatar" id="avatar"/>
						</div>
						<div class="file-path-wrapper">
							<input class="file-path validate" type="text" placeholder="Selecione uma imagem para subir">
						</div>
					</div>				
				</div>
				<a class="waves-effect waves-light btn" id="salvar"><i class="material-icons left">save</i>Salvar</a>			
			</form>	
		</div>
	</body>
</html>