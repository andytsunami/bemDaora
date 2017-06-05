<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			.material-icons{
				cursor: auto !important;
			}
			
			.reprova .material-icons, .aprova .material-icons, .conclui .material-icons{
				cursor: pointer !important;
			}
			
			.reprova{
				color: red;
			}
			
			.aprova{
				color: blue;
			}
			
			.conclui{
				color: green;
			}
			
			.hidden{
				display: none;
			}
			
		</style>
		
        <link href="<c:url value='/resources/css/adm/main-adm.css?v=3'/>" rel="stylesheet" type="text/css">
	</head>
	<body>
	<input type="hidden" id="idVaga" value="${vaga.id}">
    <div style="background:white; box-shadow: rgba(0, 0, 0, 0.25) 1px 1px 7px; padding: 1px 0; margin-bottom: 40px; border-top: #007dbe 4px solid;">
        <div class="contain">
	        <h1 class="title-adm"><img src="<c:url value='/resources/images/adm/logo.png'/>" class="logo-title" />Lista canditatos para a ${vaga.titulo}</h1>
        </div>
    </div>
    <div class="contain">
		<table class="bordered striped table-top centered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Voluntario</th>
					<th>Profissão</th>
                    <th>Level</th>
					<th>Data selecionada</th>
					<th>Aprovar</th>
                    <th>Reprovar</th>
                    <th>Realizado</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atividades}" var="atividade">
					<tr id="tr-${atividade.id}">
						<td>${atividade.id}</td>
						<td>${atividade.voluntario.nome}</td>
						<td>${atividade.voluntario.profissao.nome}</td>
						<td>${atividade.voluntario.level}</td>
						<td><fmt:formatDate value="${atividade.dataAgendada}" pattern="dd/MM/yyyy HH:mm"/></td>
						<td class="aprova acao" data-vaga="${vaga.id}" title="Aprovar candidato"><span class="material-icons">thumb_up</span></td>
						<td class="reprova acao" data-vaga="${vaga.id}" title="Reprovar candidato"><span class="material-icons">thumb_down</span></td>
						<td class="${atividade.aprovado ? 'conclui' : 'hidden'}" data-vaga="${vaga.id}" title="Atividade realizada"><span class="material-icons">done</span></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>ID</th>
					<th>Voluntario</th>
					<th>Profissão</th>
                    <th>Level</th>
					<th>Data selecionada</th>
					<th>Aprovar</th>
                    <th>Reprovar</th>
                    <th>Realizado</th>
				</tr>
			</tfoot>
		</table>
	</div><!--container-->
	</body>
</html>