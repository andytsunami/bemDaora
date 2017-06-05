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
				
				if(msg.tipoMensagem == "sucesso"){
					$.sucesso(msg);
				}
				
				if(msg.tipoMensagem == "erro"){
					$.erro(msg);
				}
				
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
					sucesso: function(msg){
						$(".sucesso h3").html(msg.mensagem);
						$(".sucesso a").attr("href",msg.link);
						$(".sucesso").removeClass("hidden");
					},
					erro: function(msg){
						$(".erro h3").html(msg.mensagem);
						$(".erro a").attr("href",msg.link);
						$(".erro").removeClass("hidden");
					}
				});
		});
})(jQuery);