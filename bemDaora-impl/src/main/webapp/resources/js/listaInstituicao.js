 $(document).ready(function(){
 	$.paramsPage = {
		contexto: "/bemdahora/adm/",
		uuid: ""
	};
 	
 	$(".edita").click(function(){
 		window.location = $.paramsPage.contexto + "editarInstituicao/" + $(this).attr("data-instituicao") + "/adm";
 	});
 	
 	$(".exclui").click(function(){
 		var instituicao = $(this).attr("data-instituicao");
 		$(this).addClass("hide");
 		$.post($.paramsPage.contexto + "excluiInstituicao",{idInstituicao: instituicao})
 		.done(function(){
 			$("#tr-" + instituicao).fadeOut(700,function(){
 				$("#tr-" + instituicao).remove();
 	 		})
 		})
 		.fail(function(){
 			$(this).removeClass("hide");
 			alert("Não foi possivel excluir esta instituição.");
 		});
 	});
 	
 	$("#add").click(function(){
 		window.location = $.paramsPage.contexto + "cadastraInstituicao";
 	});
 	
 	$("tr").click(function(){
 		
 	});
});