<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<meta name="description" content="">
		<meta name="author" content="remembr">
		<title>cadastro de Vagas</title>
		
		<bd:import-materialize/>
		
		<script type="text/javascript" src="<c:url value='/resources/js/cadastraVaga.js'/>"></script>
		
        
        <link href="<c:url value='/resources/css/adm/main-adm.css?v=3'/>" rel="stylesheet" type="text/css">

		
	</head>
	<body>
		<div style="background:white; box-shadow: rgba(0, 0, 0, 0.25) 1px 1px 7px; padding: 1px 0; margin-bottom: 40px; border-top: #007dbe 4px solid;">
	        <div class="contain">
		        <h1 class="title-adm"><img src="<c:url value='/resources/images/adm/logo.png'/>" class="logo-title" />Cadastro de Vagas para a Instiuição <strong>${instituicao.nome}</strong></h1>
		        <h2 style="float:right; margin-top: 22px; font-size: 20px;"></h2>	        										

	        </div>
    	</div>
		<div class="row">
			<div class="contain">
				<form method="post" id="form" class="col s12">
				
					<input type="hidden" name="vaga.instituicao.id" value="${instituicao.id}" id="idInstituicao">
					<input type="hidden" name="vaga.id" value="${vaga.id}">
					<div class="row">
						<div class="input-field col s6">
							<input type="text" name="vaga.titulo" id="titulo" class="validate" value="${vaga.titulo}"/>
							<label for="titulo">Titulo da Vaga</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<textarea name="vaga.descricao" class="materialize-textarea" id="descricao">${vaga.descricao}</textarea>
							<label for="descricao">Desrição da vaga. (Se possivel detalhe as atividades.)</label>
						</div>				
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input type="number" name="vaga.quantidade" id="quantidade" class="validate" value="${vaga.quantidade}" min="1"/>
							<label for="quantidade">Quantidade de vagas disponiveis</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<select name="vaga.ramoAtividade.id">
						      	<option value="" disabled="disabled" ${empty vaga.ramoAtividade.id ? 'selected="selected"' : ''}>Escolha um ramo de atividade</option>
						    	<c:forEach items="${ramos}" var="ramo">
						    		<option value="${ramo.id}" ${ramo.id == vaga.ramoAtividade.id ? 'selected="selected"' : ''} >${ramo.nome}</option>
						      	</c:forEach>
						    </select>
						    <label>Ramo de atividade</label>
						</div>				
					</div><br />
					<div class="row">
						<div class="input-field col s6">
							<a class="waves-effect waves-light btn blue" id="publicar"><i class="material-icons left">save</i>Publicar vaga</a>
						</div>
					</div>			
				</form>
				<div class="fixed-action-btn">
				<a class="btn-floating btn-large red">
					<i class="large material-icons" id="voltaInstituicao" title="Voltar para a instituição">fast_rewind</i>
				</a>
			 </div>	
			</div>
		</div><!--row-->
	</body>
</html>