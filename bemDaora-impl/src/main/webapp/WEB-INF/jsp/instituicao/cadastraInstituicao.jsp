<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="remembr">
		<title>cadastro de instituição</title>
		
		<script type="text/javascript" src="<c:url value='/resources/jquery/jquery-1.12.4.min.js'/>"></script>
		
		<script type="text/javascript" src="<c:url value='/resources/js/cadastraInstituicao.js'/>"></script>
		
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/normalize.css'/>">
		
	</head>
	<body>
		<h1>Cadastro de Instituição</h1>
		
		<form method="post" id="form" enctype="multipart/form-data">
			<label>Nome contato</label>
			<input type="text" name="instituicao.nome" />
			
			<label>Razão Social</label>
			<input type="text" name="instituicao.razaoSocial" />
			
			<label>Email</label>
			<input type="text" name="instituicao.email" />
			
			<label>Nome CNPJ</label>
			<input type="text" name="instituicao.cnpj" />
			
			<label>Sobre</label>
			<textarea name="instituicao.sobre">
			</textarea>
			
			<label>Avatar</label>
			<input type="file" name="avatar"/>
			
			<label>Endereco</label>
			<input type="text" name="instituicao.endereco"/>
			
			<input type="button" value="Salvar" id="salvar"/>			
		</form>	
	</body>
</html>