 $(document).ready(function(){
 	$.paramsPage = {
		contexto: "/bemdaora/",
		uuid: ""
	};
 	
 	$("#salvar").click(function(){
 		$("#form").attr("action",$.paramsPage.contexto + "salvaInstituicao/adm").submit();
 	});
 	
 	$("#add-vaga").click(function(){
 		window.location = $.paramsPage.contexto + "cadastraVaga/"+$("#idInstituicao").val()+"/adm";
 	});
 	
 	$(".editaVaga").click(function(){
 		window.location = $.paramsPage.contexto + "editaVaga/" + $(this).attr("data-vaga") + "/adm";
 	});
 	
 	$(".excluiVaga").click(function(){
 		var vaga = $(this).attr("data-vaga");
 		$(this).addClass("hide");
 		$.post($.paramsPage.contexto + "excluiVaga/adm",{idVaga: vaga})
 		.done(function(){
 			$("#tr-" + vaga).fadeOut(700,function(){
 				$("#tr-" + vaga).remove();
 	 		})
 		})
 		.fail(function(){
 			$(this).removeClass("hide");
 			alert("Não foi possivel excluir esta instituição.");
 		});
 	});
 	
 	$("#listar").click(function(){
 		window.location = $.paramsPage.contexto + "adm/listaInstituicao"
 	});
});