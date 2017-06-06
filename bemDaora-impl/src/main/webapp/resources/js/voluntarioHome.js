(function($) {
		$().ready(function() {
			$.paramsPage = {
					accessToken : "",
					contexto : "/bemdahora/usuario/",
				};
			
			/*WEBSOCKET!!*/
			var ws = new WebSocket("ws://apresentacao.top/bemdahora/socket/"+$("#login").val());
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
				
				if(msg.tipoMensagem == "badge"){
					$.badge(msg);
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
					badge: function(msg){
						$(".badge h3").html(msg.mensagem);
						$(".badge").attr("href",msg.link);
						$(".badge").addClass("sucesso");
												
						
						var audioElement = document.createElement('audio');
					    audioElement.setAttribute('src', '/bemdahora/resources/songs/kids.mp3');
					    
					    audioElement.addEventListener('ended', function() {
					        this.play();
					    }, false);
					    
					    audioElement.play();
					    setInterval(() => {
					    	audioElement.pause();
						}, 5000);
					    
					    $.paramsPage.box = $.fancybox.open([{
							href : ".badge",
							type:'inline',
							 afterClose : function() {
								 $(".badge").removeClass("sucesso");
							    },
							tpl: { 
								closeBtn: '<div title="Fechar" class="fancybox-item fancybox-close"></div>' 
							}}], {padding : 10});
					    
					},
					erro: function(msg){
						$(".erro h3").html(msg.mensagem);
						$(".erro a").attr("href",msg.link);
						$(".erro").removeClass("hidden");
					}
				});
		});
})(jQuery);