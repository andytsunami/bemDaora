(function($) {
		$().ready(function() {
			$.context = {
					accessToken : "",
					contexto : "/bemdahora/voluntario/",
				};
				
				$("#saveSegundo").click(function(){
					
					if($.preValidate()){
						$("#form").attr("action",$.context.contexto + "salvaSegundo").submit();
					} else {
						alert($.context.mensagemErro);
					}
				});
				
				
				$("#saveTerceiro").click(function(){
					
					if($.preValidate()){
						$("#form").attr("action",$.context.contexto + "salvaTerceiro").submit();
					} else {
						alert($.context.mensagemErro);
					}
				});
			
		});
})(jQuery);