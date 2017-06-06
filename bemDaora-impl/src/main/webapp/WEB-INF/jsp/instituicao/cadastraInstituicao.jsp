<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
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
        input:focus{border-bottom:1px solid #f0f;}
        </style>
        
		
        <link href="<c:url value='/resources/css/adm/set1.css?v=3'/>" rel="stylesheet" type="text/css">
        <link href="<c:url value='/resources/css/adm/main-adm.css?v=3'/>" rel="stylesheet" type="text/css">
	</head>
	<body>
		<c:set var="h1" value="Cadastro de Instituição"/>
		<c:if test="${not empty instituicao.id}">
			<c:set var="h1" value="Editar instituição ${instituicao.nome}"/>
		</c:if>
        
		<div style="background:white; box-shadow: rgba(0, 0, 0, 0.25) 1px 1px 7px; padding: 1px 0; margin-bottom: 40px; border-top: #007dbe 4px solid;">
            <div class="contain">
                <h1 class="title-adm"><img src="<c:url value='/resources/images/adm/logo.png'/>" class="logo-title" />Cadastro de Instituição</h1>
				
            </div>
   		</div>
        
		<div class="row">
		<div class="contain">
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
						<textarea name="instituicao.valores" class="materialize-textarea" id="sobre">${instituicao.valores}</textarea>
						<label for="sobre">Valores da empresa</label>
					</div>				
				</div>
				<div class="row">
					<div class="input-field col s6">
						<textarea name="instituicao.historia" class="materialize-textarea" id="sobre">${instituicao.historia}</textarea>
						<label for="sobre">Historia da empresa</label>
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
						<div class="btn blue">
							<span>Avatar</span>						
							<input type="file" name="avatar" id="avatar"/>
						</div>
						<div class="file-path-wrapper">
							<input class="file-path validate" type="text" placeholder="Selecione uma imagem para subir">
						</div>
					</div>				
				</div>
				
				<div class="row">
					<div class="file-field input-field col s6">
						<div class="btn blue">
							<span>Galeria</span>						
							<input type="file" name="galeria[]" id="galeria" multiple/>
						</div>
						<div class="file-path-wrapper">
							<input class="file-path validate" type="text" placeholder="Selecione varias imagens para subir">
						</div>
						
						<br/><br/><br/>
						<div class="waves-effect waves-light btn red" id="limpar">
							<span><i class="material-icons left">delete</i>Limpar a galeria</span>						
						</div>
					</div>				
				</div>
				<br/><br/><br/>
				
				<a class="waves-effect waves-light btn blue" id="salvar"><i class="material-icons left">save</i>Salvar</a>			
			</form>
			
			<c:if test="${not empty instituicao.id}">
				<div class="fixed-action-btn">
				    <a class="btn-floating btn-large green">
				      <i class="large material-icons" id="add-vaga" title="Adicionar vagas">add</i>
				    </a>
				    <ul>
      					<li><a class="btn-floating blue" id="listar"><i class="material-icons" title="Listar instituições">list</i></a></li>
      					<li><a data-inst="${instituicao.id}" class="btn-floating red" id="candidatos"><i class="material-icons" title="Listar vagas">list</i></a></li>
      				</ul>
			 	</div>
		 	</c:if>
		 </div>	<!--contain-->
		</div><!--row-->
	</body>
</html>