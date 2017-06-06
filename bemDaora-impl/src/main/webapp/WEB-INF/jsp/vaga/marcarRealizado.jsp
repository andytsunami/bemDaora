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
		<title>Marcar realizado</title>
		
		
		
		<bd:import-materialize/>
		<script type="text/javascript" src="<c:url value='/resources/js/cadastraInstituicao.jssss'/>"></script>
		
		<style>
        input:focus{border-bottom:1px solid #f0f;}
        </style>
        
		
        <link href="<c:url value='/resources/css/adm/set1.css?v=3'/>" rel="stylesheet" type="text/css">
        <link href="<c:url value='/resources/css/adm/main-adm.css?v=3'/>" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div style="background:white; box-shadow: rgba(0, 0, 0, 0.25) 1px 1px 7px; padding: 1px 0; margin-bottom: 40px; border-top: #007dbe 4px solid;">
            <div class="contain">
                <h1 class="title-adm"><img src="<c:url value='/resources/images/adm/logo.png'/>" class="logo-title" />Confirmar realização da atividade ${atividade.vaga.titulo}</h1>
				
            </div>
   		</div>
        
		<div class="row">
		<div class="contain">
			<form method="post" id="form" enctype="multipart/form-data" class="col s12">
			<input type="hidden" name="instituicao.id" value="${instituicao.id}" id="idInstituicao">
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="instituicao.razaoSocial" id="razaoSocial" class="validate" value="${instituicao.razaoSocial}"/>
						<label for="razaoSocial">Razão Social</label>
					</div>
				</div>
				<br/><br/><br/>
				
				<a class="waves-effect waves-light btn blue" id="salvar"><i class="material-icons left">save</i>Salvar</a>			
			</form>
		 </div>	<!--contain-->
		</div><!--row-->
	</body>
</html>