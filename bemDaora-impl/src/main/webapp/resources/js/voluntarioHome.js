(function($) {
		$().ready(function() {
			$.paramsPage = {
					accessToken : "",
					contexto : "/bemdahora/usuario/",
				};
			
			/*WEBSOCKET!!*/
			var ws = new WebSocket("ws://localhost:8080/bemdahora/socket/"+$("#login").val());
			 ws.onopen = function()
			 {
				console.log("Websocket conectado!");			        
			 };
			 ws.onmessage = function (evt) 
			 { 			     	
				var msg = JSON.parse(evt.data);
				alert("Quem é o ususario? " +  msg.usuario);
				alert("Qual tipo? " +  msg.tipoMensagem);
			 };
			 ws.onclose = function()
			 { 
				console.log("Conexão fechada..."); 
			 };
			 /*FIM WEBSOCKET*/
			 
			 $.extend({
					
					sendMessage: function(){
						ws.send("Mensagem enviada para o servidor");
					},
					
						
				});
		});
})(jQuery);