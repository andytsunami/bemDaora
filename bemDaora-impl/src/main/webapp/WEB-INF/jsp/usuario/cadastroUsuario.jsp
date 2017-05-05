<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de usuario</title>
</head>
<body>
	<form action="/bemdaora/usuario/salvar" method="post">
		<label>Nome</label>
		<input type="text" name="usuario.nome" value="${usuario.nome}">
		<label>Email</label>
		<input type="text" name="usuario.email" value="${usuario.email}">
		<label>Idade</label>
		<input type="text" name="usuario.idade" value="${usuario.idade}">
		<label>Senha</label>
		<input type="password" name="usuario.senha" value="">
		
		<input type="submit" value="Salvar">
	</form> 
</body>
</html>