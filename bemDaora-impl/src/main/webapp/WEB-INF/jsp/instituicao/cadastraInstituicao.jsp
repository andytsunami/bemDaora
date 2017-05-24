<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<meta name="description" content="">
		<meta name="author" content="remembr">
		<title>cadastro de instituição</title>
		
		<bd:import-materialize/>
		
		<script type="text/javascript" src="<c:url value='/resources/js/cadastraInstituicao.js'/>"></script>
		
		<style>
			body{
				margin-left: 25%;
			}
		</style>
		
	</head>
	<body>
		<c:set var="h1" value="Cadastro de Instituição"/>
		<c:if test="${not empty instituicao.id}">
			<c:set var="h1" value="Editar instituição ${instituicao.nome}"/>
		</c:if>
		<h1>${h1}</h1>
		<div class="row">
			<form method="post" id="form" enctype="multipart/form-data" class="col s12">
			
			<input type="hidden" name="instituicao.id" value="${instituicao.id}" id="idInstituicao">
			
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.nome" id="nome" class="validate" value="${instituicao.nome}"/>
						<label for="nome">Nome contato</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.razaoSocial" id="razaoSocial" class="validate" value="${instituicao.razaoSocial}"/>
						<label for="razaoSocial">Razão Social</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.email" class="validate" id="email" value="${instituicao.email}"/>
						<label for="email">Email</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.cnpj" class="validate" id="cnpj" value="${instituicao.cnpj}"/>
						<label for="cnpj">Nome CNPJ</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<textarea name="instituicao.sobre" class="materialize-textarea" id="sobre">${instituicao.sobre}</textarea>
						<label for="sobre">Sobre</label>
					</div>				
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.endereco" class="validate" id="endereco" value="${instituicao.endereco}"/>
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
			<c:if test="${not empty instituicao.id}">
				<div class="fixed-action-btn">
				    <a class="btn-floating btn-large red">
				      <i class="large material-icons" id="add-vaga" title="Adicionar vagas">add</i>
				    </a>
			 	</div>
		 	</c:if>	
		</div>
	</body>
</html>