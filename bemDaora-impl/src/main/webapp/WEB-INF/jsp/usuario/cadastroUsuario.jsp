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

<title>cadastro</title>

<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css">


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- FONT AWESOME -->

<link rel="stylesheet" href="font-awesome-4.7.0\css/font-awesome.min.css">
<!-- FONT AWESOME -->

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/normalize.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/demo.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/set1.css'/>" />

<script type="text/javascript">
(function($) {
	$().ready(function() {
		$.context = {
				accessToken : "",
				contexto : "/bemdaora/usuario/",
			};
		
		$('#fb-logout').attr('style', 'display:none;');
		
		(function(d){
			   var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
			   if (d.getElementById(id)) {return;}
			   js = d.createElement('script'); js.id = id; js.async = true;
			   js.src = "//connect.facebook.net/en_US/all.js";
			   ref.parentNode.insertBefore(js, ref);
			 }(document));
		
		window.fbAsyncInit = function() {
			  FB.init({
			    appId      : '433719330308088',
			    xfbml      : true,
			    version    : 'v2.8',
			    status     : true,
			    cookie     : true
			  });

			  // Tipos de permissão que irá ser pedida ao usuário.
			  var permissions = [
			    'email',
			    'user_birthday',
			  ].join(',');

			  // Campos que vão ser retornados após o login ser confirmado
			  var fields = [
			    'id',
			    'name',
			    'first_name',
			    'middle_name',
			    'last_name',
			    'birthday',
			    'email',
			    'gender',
			  ].join(',');

			  
			  
			  function showDetails() {
			    FB.api('/me', {fields: fields}, function(details) {
			      // Imprime no HTML os dados do usuário
			      $('#userdata').html(JSON.stringify(details, null, '\t'));
			      
			      // Salvar os dados no banco de dados ou verificar se ja existe e carregar dados do usuário.
			      console.log(details);
			      console.log("Token - " + $.context.accessToken);
			      
			      $("#nome").val(details.name);
			      $("#email").val(details.email);
			      $("#senha").val($.context.accessToken);
			      
			      var dataNascimento = new Date(details.birthday);
			      var idade = calculaData(dataNascimento,new Date());
			      
			      $("#idade").val(idade);
			      
			      
			      
			      
			      
			     /* try 
			      {
			        $.ajax({
			          method: "POST",
			          url: 'login_usuario.php',
			          data: {dados: details}
			        })
			        .done(function(data) {
			          debugger;
			            $('#serverData').html(JSON.stringify(data, null, '\t'));
			            alert("Usuario Cadastrado");
			        });
			      }
			      catch (e)
			      {
			        alert("Pagina inexistente");
			      }
			      */
			      
			      
			      $('#fb-login').attr('style', 'display:none;');
			      $('#fb-logout').attr('style', 'display:display;');
			    });
			  }


			  $('#fb-login').click(function(){
			   // fbAsyncInit(); Fica doido e faz varias vezes
			    // Tenta fazer o login
			    FB.login(function(response) { 
			      // Se usuário está logado ....
			      if(response.authResponse) {
			          showDetails();
			          $.context.accessToken = response.authResponse.accessToken;
			          console.log(response);
			      }
			    }, {scope: permissions});
			  });
			  
			  $("#fb-logout").click(function(){
			            FB.logout(function(response) {
			              // Usuario agora está deslogado
					          console.log(response);
			            });
				  
				  $('#fb-login').attr('style', 'display:display;');
				  $('#fb-logout').attr('style', 'display:none;');
			  });
			  
			  $("#cadastrar").click(function(){
				  $("#form").attr("action",$.context.contexto + "/salvar").submit();
			  });
			  
			  function calculaData(dateold, datenew) {
		            var ynew = datenew.getFullYear();
		            var mnew = datenew.getMonth();
		            var dnew = datenew.getDate();
		            var yold = dateold.getFullYear();
		            var mold = dateold.getMonth();
		            var dold = dateold.getDate();
		            var diff = ynew - yold;
		            if (mold > mnew) diff--;
		            else {
		                if (mold == mnew) {
		                    if (dold > dnew) diff--;
		                }
		            }
		            return diff;
		        }

			};
		
		
	});
})(jQuery);
</script>

</head>
<body>
<form id="form" method="post">
	<div style="max-width: 600px; margin: auto; box-shadow: rgba(0, 0, 0, 0.1) 1px 1px 7px;">
		<div id="cont" style="bottom: 30px; padding-top: 50px;">
			<center>
				<h3>CADASTRO</h3>
			</center>
			<section class="" style="margin: auto; max-width: 348px; min-width: 300px; width: 100%;">

			<span class="input input--hoshi"> 
				<input class="input__field input__field--hoshi" type="text" id="nome" /> 
				<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-4">
					<span class="input__label-content input__label-content--hoshi">Nome</span>
				</label>
			</span> 
			<span class="input input--hoshi"> 
			
			<input class="input__field input__field--hoshi" type="text" id="email" />
			<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="input-5">
				<span class="input__label-content input__label-content--hoshi">E-mail</span>
			</label>

				</span> <span class="input input--hoshi"> 
				
				<input class="input__field input__field--hoshi" type="password" id="senha" /> 
				<label class="input__label input__label--hoshi input__label--hoshi-color-1"	for="input-5">
					<span class="input__label-content input__label-content--hoshi">Senha</span>
				</label>

				</span> <span class="input input--hoshi"> 

				<input class="input__field input__field--hoshi" type="date" id="idade" /> 
				<label class="input__label input__label--hoshi input__label--hoshi-color-1"
					for="input-5"> 
					<span class="input__label-content input__label-content--hoshi">Idade</span>

				</label>

				</span> <span class="input input--hoshi">
</form>
					<center>
						<input type="submit" value="CADASTRAR" class="botao" id="cadstrar">
					</center>

				</span>

			</section>

			<section class=""
				style="margin: auto; max-width: 348px; min-width: 300px; width: 100%;">
				<center>OU</center>
				<br />

				<center>
					<input type="submit" value="ENTRAR COM FACEBOOK" class="botao"
						style="background: #3B5998" id="fb-login">
				</center>

				<br />

				<center>
					<input type="submit" value="ENTRAR COM GOOGLE+" class="botao"
						style="background: #C20807">
				</center>

				<br /> <a href="#"><p
						style="font-size: 12px; color: #999999; text-align: center;">
						<i class="fa fa-arrow-left" aria-hidden="true"></i> VOLTAR
					</p></a>
			</section>


		</div>
	</div>
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

			[].slice.call(document.querySelectorAll('input.input__field'))
					.forEach(function(inputEl) {

						// in case the input is already filled..

						if (inputEl.value.trim() !== '') {

							classie.add(inputEl.parentNode, 'input--filled');

						}

						// events:

						inputEl.addEventListener('focus', onInputFocus);

						inputEl.addEventListener('blur', onInputBlur);

					});

			function onInputFocus(ev) {

				classie.add(ev.target.parentNode, 'input--filled');

			}

			function onInputBlur(ev) {

				if (ev.target.value.trim() === '') {

					classie.remove(ev.target.parentNode, 'input--filled');

				}

			}

		})();
	</script>
</body>
</html>