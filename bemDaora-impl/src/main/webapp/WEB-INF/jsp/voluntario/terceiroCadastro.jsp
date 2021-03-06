<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="bd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Cadastro do ${voluntario.nome}</title>

      <bd:import-estilos/>
      <script type="text/javascript" src="<c:url value='/resources/js/continuaCadastro.js'/>"></script>
   </head>
   <body>
      <div class="container">
         <div id="cont">
            <div class="perfil-quase-pronto">
                <p>Olá, ${voluntario.nome}!</p>
                <p>Seu perfil está quase pronto!</p>
                <br/>
                <div class="barra-concluir-perfil">
                    <div class="skills-concluir-perfil ultimoCadastro"><center>80%</center></div>
                </div>
            </div>
           <div class="" style="margin:auto; max-width: 348px; min-width: 300px;">
            	<h2 style="color:#2072b5; margin-top: 20px;">Informe seus dados abaixo</h2>
            	<form id="form" method="post" accept-charset="UTF-8" enctype="multipart/form-data">
            	<input type="hidden" name="voluntario.id" value="${voluntario.id}">
	               	<span class="input input--hoshi">
	               	<input class="input__field input__field--hoshi" type="file" id="avatar" name="avatar" value=""/>
	               	<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="avatar">
	              	<span class="input__label-content input__label-content--hoshi">Escolha uma foto para ser seu Avatar</span>
	               	</label>
	               	</span>
	               	
	               	<span class="input input--hoshi">
	               	<input class="input__field input__field--hoshi obrigatorio" type="text" id="endereco" name="voluntario.endereco" value="${voluntario.endereco}"/>
	               	<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="endereco">
	              	<span class="input__label-content input__label-content--hoshi">Endereço</span>
	               	</label>
	               	</span>
	               	
	               	<span class="input input--hoshi">
		               	<input class="input__field input__field--hoshi obrigatorio telefone" type="text" id="telefone" value="${voluntario.telefone}" name="voluntario.telefone"/>
		               	<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="telefone">
		               	<span class="input__label-content input__label-content--hoshi">Telefone</span>
	               	</label>
	               	</span>
	               	<span class="input input--hoshi">
	               	<textarea class="input__field input__field--hoshi default" rows="3" cols="1" name="voluntario.sobre" id="sobre">${voluntario.sobre}</textarea>
	               	<label class="input__label input__label--hoshi input__label--hoshi-color-1 default obrigatorio" for="sobre">
	               	<span class="input__label-content input__label-content--hoshi">Sobre mim</span>
	               	</label>
	               	</span>
	               	<span class="input input--hoshi">
	                  <center><input type="button" value="COMPLETAR" class="botao" id="saveTerceiro"></center>
	               	</span>
               	</form>
            </div>
            <a href="/bemdahora/voluntario/voltaSegundoCadastro/${voluntario.id}">
            	<p style="font-size:12px; color: #999999; text-align: center;"> <i class="fa fa-arrow-left" aria-hidden="true"></i>VOLTAR</p>
            </a>
         
         </div><!--/cont-->
      </div>
   </body>
</html>