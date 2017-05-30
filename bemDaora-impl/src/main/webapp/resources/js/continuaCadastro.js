(function($) {
		$().ready(function() {
			$.context = {
					accessToken : "",
					contexto : "/bemdaora/voluntario/",
				};
				
				$("#saveSegundo").click(function(){
					
					if($.preValidate()){
						$("#form").attr("action",$.context.contexto + "salvaSegundo").submit();
					} else {
						alert($.context.mensagemErro);
					}
				});
			
		});
})(jQuery);