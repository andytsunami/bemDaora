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
		
		<script type="text/javascript" src="<c:url value='/resources/js/listaInstituicao.js'/>"></script>
		
		<style>
			
			
			.exclui{
				color: red;
			}
			
			.material-icons{
				cursor: pointer;	
			}
		</style>
		
	</head>
	<body>
		<h1>Lista Instituições</h1>
		<table class="bordered striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Endereço</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${instituicoes}" var="inst">
					<tr id="tr-${inst.id}">
						<td>${inst.id}</td>
						<td>${inst.nome}</td>
						<td>${inst.endereco}</td>
						<td class="material-icons edita" data-instituicao="${inst.id}" title="Editar">mode_edit</td>
						<td class="material-icons exclui" data-instituicao="${inst.id}" title="Excluir">delete</td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Endereço</th>
					<th></th>
					<th></th>
				</tr>
			</tfoot>
		</table>
		<div class="fixed-action-btn">
		    <a class="btn-floating btn-large red">
		      <i class="large material-icons" id="add">add</i>
		    </a>
		 </div>
	</body>
</html>