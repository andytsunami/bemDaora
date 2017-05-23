<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

	  <title>Bem vindo ao Bemdaora</title>
	  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
	  <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
	  
	  <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css">
	  <!-- FONT AWESOME -->
	  
	  <link rel="stylesheet" href="<c:url value='/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css'/>">
	  <!-- FONT AWESOME -->

    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/normalize.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/demo.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/set1.css'/>" />

</head>
<body>
	<form action="<c:url value='/login'/>" method="post">
		 <div style="max-width: 600px; margin: auto; box-shadow: rgba(0, 0, 0, 0.1) 1px 1px 7px;">
			<div id="cont" style="bottom: 30px;padding-top:50px;">
		    	<center><img src="imgs/logo.png" /></center>
					<section class="" style="margin:auto; max-width: 348px; min-width: 300px; width: 100%;">
						<span class="input input--hoshi">
							<input class="input__field input__field--hoshi" type="text" id="email" name="login.email"/>
							<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-4">
								<span class="input__label-content input__label-content--hoshi">E-MAIL</span>
							</label>
						</span>
						<span class="input input--hoshi">
							<input class="input__field input__field--hoshi" type="password" id="senha" name="login.senha"/>
							<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-5">
								<span class="input__label-content input__label-content--hoshi">SENHA</span>
							</label>
						</span>
		                <span class="input input--hoshi">
		                <center><input type="submit" value="ENTRAR" class="botao"></center>
		                </span>
					</section>
		    	<center><input type="button" value="ENTRAR COM FACEBOOK" class="botao" style="background:#3B5998"></center>
		        <br/>
		        <center><input type="button" value="ENTRAR COM GOOGLE+" class="botao" style="background:#C20807"></center>
		        <br/>
		        <table class="cadastro-esqueci-senha">
		        	<tr>
		            	<td style="border-right: 1px solid #999999; padding-right:  20px;"><a href="#">CADASTRAR</a></td>
		                <td style="padding-left: 34px;"><a href="#">ESQUECI A SENHA</a></td>
		            </tr>
		        </table>
			</div>
		  </div>
	</form>
<script src="<c:url value='/resources/js/classie.js'/>"></script>
		<script>
			(function() {
				// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
				if (!String.prototype.trim) {
					(function() {
						// Make sure we trim BOM and NBSP
						var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
						String.prototype.trim = function() {
							return this.replace(rtrim, '');

						};

					})();

				}

				[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
					// in case the input is already filled..
					if( inputEl.value.trim() !== '' ) {
						classie.add( inputEl.parentNode, 'input--filled' );
					}
					// events:
					inputEl.addEventListener( 'focus', onInputFocus );
					inputEl.addEventListener( 'blur', onInputBlur );

				} );

				function onInputFocus( ev ) {

					classie.add( ev.target.parentNode, 'input--filled' );

				}
				
				function onInputBlur( ev ) {

					if( ev.target.value.trim() === '' ) {

						classie.remove( ev.target.parentNode, 'input--filled' );

					}

				}

			})();

		</script>
</body>
</html>