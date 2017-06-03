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
				var msg = evt.data;
				alert("Mensagem recebida:" +  msg);
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