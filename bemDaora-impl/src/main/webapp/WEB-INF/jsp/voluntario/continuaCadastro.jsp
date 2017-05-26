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
      
      
   </head>
   <body>
      <div class="container">
         <div id="cont">
            <div class="perfil-quase-pronto">
                <p>Olá, ${voluntario.nome}!</p>
                <p>Seu perfil está quase pronto!</p>
                <br/>
                <div class="barra-concluir-perfil">
                    <div class="skills-concluir-perfil level-concluir-perfil"><center>60%</center></div>
                </div>
            </div>
           <div class="" style="margin:auto; max-width: 348px; min-width: 300px;">
            	<h2 style="color:#2072b5; margin-top: 20px;">Informe seus dados abaixo</h2>
            	<form>
               	<span class="input input--hoshi">
               	<input class="input__field input__field--hoshi" type="text" id="" />
               	<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-4">
              	<span class="input__label-content input__label-content--hoshi">Nome Completo</span>
               	</label>
               	</span>
               	<span class="input input--hoshi">
               	<input class="input__field input__field--hoshi" type="text" id="" disabled="disabled"/>
               	<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-5">
               	<span class="input__label-content input__label-content--hoshi">E-mail</span>
               	</label>
               	</span>
               	<span class="input input--hoshi">
               	<input class="input__field input__field--hoshi" type="text" id="" />
               	<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-5">
               	<span class="input__label-content input__label-content--hoshi">Profissão</span>
               	</label>
               	</span>
               	<span class="input input--hoshi">
               	<input class="input__field input__field--hoshi" type="text" id="" />
               	<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-5">
               	<span class="input__label-content input__label-content--hoshi">CPF</span>
               	</label>
               	</span>
               	<span class="input input--hoshi">
                  <center><input type="button" value="COMPLETAR" class="botao"></center>
               	</span>
               	</form>
            </div>
            <a href="/bemdaora">
            	<p style="font-size:12px; color: #999999; text-align: center;"> <i class="fa fa-arrow-left" aria-hidden="true"></i>VOLTAR</p>
            </a>
         
         </div><!--/cont-->
      </div>
   </body>
</html>