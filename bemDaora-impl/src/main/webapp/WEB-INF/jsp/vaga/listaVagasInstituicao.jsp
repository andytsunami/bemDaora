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
		<title>Vagas</title>
		
		<bd:import-materialize/>		
		<script type="text/javascript" src="<c:url value='/resources/js/listaVagas.js?v=3'/>"></script>
		
		<style>
			.excluiVaga{
				color: red;
			}
		</style>
		
        <link href="<c:url value='/resources/css/adm/main-adm.css?v=3'/>" rel="stylesheet" type="text/css">
	</head>
	<body>
    <div style="background:white; box-shadow: rgba(0, 0, 0, 0.25) 1px 1px 7px; padding: 1px 0; margin-bottom: 40px; border-top: #007dbe 4px solid;">
        <div class="contain">
	        <h1 class="title-adm"><img src="<c:url value='/resources/images/adm/logo.png'/>" class="logo-title" />Lista vagas</h1>
        </div>
    </div>
    <div class="contain">
		<table class="bordered striped table-top centered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Titulo</th>
					<th>Profissão</th>
					<th>Quantidade</th>
                    <th>Candidatos</th>
					<th>&nbsp</th>
                    <th>&nbsp</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${vagas}" var="vaga">
					<tr id="tr-${vaga.id}">
						<td>${vaga.id}</td>
						<td>${vaga.titulo}</td>
						<td>${vaga.ramoAtividade.nome}</td>
						<td>${vaga.quantidade}</td>
						<td class="candidatos acao" data-vaga="${vaga.id}" title="Candidatos"><span class="material-icons">assignment_ind</span></td>
						<td class="editaVaga acao" data-vaga="${vaga.id}" title="Editar"><span class="material-icons">mode_edit</span></td>
						<td class="excluiVaga acao" data-vaga="${vaga.id}" title="Excluir"><span class="material-icons">delete</span></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>ID</th>
					<th>Titulo</th>
					<th>Profissão</th>
					<th>Quantidade</th>
                    <th>Candidatos</th>
					<th>&nbsp</th>
                    <th>&nbsp</th>
				</tr>
			</tfoot>
		</table>
	</div><!--container-->
	
	</body>
</html>