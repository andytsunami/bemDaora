(function($) {
		$().ready(function() {
			$.context = {
					accessToken : "",
					contexto : "/bemdahora/vaga/",
					contextoInstituicao : "/bemdahora/instituicao/",
				};
			
			
			
			
			$("#confirma").click(function(){
				if($("#dataAgendada").val() != ""){
					$.post($.context.contexto + "agenda",{
						idVaga : $("#idVaga").val(),
						idVoluntario : $("#idVoluntario").val(),
						dataAgendada : new Date($("#dataAgendada").val()).toISOString(),
					})
					.done(function(data){
						if(data != undefined){
							window.location = $.context.contextoInstituicao + $("#idInstituicao").val() + "?agendado=true";
						}
					})
					.fail(function(){
						alert("Não foi possivel realizar o agendamento.");
					});
				}
			});
		});
})(jQuery);