<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
(function($) {
	$().ready(function() {
		$.context = {
				accessToken : "",
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

			};
		
		
	});
})(jQuery);
</script>
<title>Cadastro de usuario</title>
</head>
<body>
	<form action="/bemdahora/usuario/salvar" method="post">
		<label>Nome</label>
		<input type="text" name="usuario.nome" value="${usuario.nome}" id="nome">
		<label>Email</label>
		<input type="text" name="usuario.email" value="${usuario.email}" id="email">
		<label>Idade</label>
		<input type="text" name="usuario.idade" value="${usuario.idade}" id="idade">
		<label>Senha</label>
		<input type="password" name="usuario.senha">
		
		<input type="submit" value="Salvar">
	</form>
	<button id="fb-login" value="Login">Login</button>
	<button id="fb-logout" value="Logout">Logout</button>
	<!-- 
	<div id="fb-root"></div>

        <script>
        window.fbAsyncInit = function() {
                FB.init({
                appId: '433719330308088',
                status: true,
                cookie: true,
                xfbml: true,
                version : 'v2.8'
            });
        };

        // Load the SDK asynchronously
        (function(d){
        var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement('script'); js.id = id; js.async = true;
        js.src = "//connect.facebook.net/en_US/all.js";
        ref.parentNode.insertBefore(js, ref);
        }(document));

        function login() {
            FB.login(function(response) {

            // handle the response
            console.log("Response goes here!");
            console.log(response);

            }/*, {scope: 'read_stream,publish_stream,publish_actions,read_friendlists'}*/); //Está errado!            
        }
        
        function publica(texto){
        	
        FB.login(function(){
        	  // Note: The call will only work if you accept the permission request
        	  FB.api('/me/feed', 'post', {message: texto});
        	}, {scope: 'publish_actions'});
        }

        function logout() {
            FB.logout(function(response) {
              // user is now logged out
            });
        }

        var status = FB.getLoginStatus();

        console.log(status);

        </script>

        <button onclick="javascript:login();">Login Facebook</button>
        <button onclick="javascript:publica('Hello World!');">Publica</button>

        <br>

<button onclick="javascript:logout();">Logout from Facebook</button> --> 
</body>
<script type="text/javascript">


	
</script>
</html>