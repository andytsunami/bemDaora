(function($) {
		$().ready(function() {
			$.context = {
					accessToken : "",
					contexto : "/bemdahora/vaga/",
					contextoInstituicao : "/bemdahora/instituicao/",
				};
			
			
			$("#confirmaa").click(function(){
				alert(toDate($("#dataAgendada").val()));
			});

			function toDate(dateStr) {
			    var parts = dateStr.split("-");
			    var diaPart = parts[2].split("T")
			    return diaPart[0] + "/" + parts[1] + "/" + parts[0] + " " + diaPart[1];
			}
			
			$("#confirma").click(function(){
				if($("#dataAgendada").val() != ""){
					$.post($.context.contexto + "agenda",{
						idVaga : $("#idVaga").val(),
						idVoluntario : $("#idVoluntario").val(),
						dataAgendada : toDate($("#dataAgendada").val()),
						qtdHora : $("#qtdHora").val()
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