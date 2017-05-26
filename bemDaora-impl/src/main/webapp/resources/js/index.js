(function($) {
		$().ready(function() {
			$.context = {
					accessToken : "",
					contexto : "/bemdaora/",
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
				      
				      $("#email").val(details.email);
				      //$("#senha").val($.context.accessToken);
				      $("#rede").val(details.id);
				      $("#rede").attr("name","login.senha");
			          $("#senha").attr("name","");
			          $("#form").attr("action",$.context.contexto + "login");
				      
				      var dataNascimento = new Date(details.birthday);
				      var idade = calculaData(dataNascimento,new Date());
				      
				      $("#idade").val(idade);
				      
				      $('#fb-login').attr('style', 'display:none;');
				      $('#fb-logout').attr('style', 'display:display;');
				      
				      console.log("Formulario completo")
				      
				      if(details.id != ""){
					    	console.log("Vai?");
					    	$("#form").submit();
					    }
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
						console.log("Fim do if");          
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
					  $("#rede").attr("name","usuario.senha");
					  $("#senha").attr("name","");
					  $("#form").attr("action",$.context.contexto + "salvar/adm");
					  $("#form").submit();
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
	
				};
		});
})(jQuery);